package com.leetcode.example.uniqueBinarySearchTreesII;


import com.leetcode.example.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * 95. Unique Binary Search Trees II
 * Given an integer n, return all the structurally unique BST's (binary search trees),
 * which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
 *
 * Example 1:
 * Input: n = 3
 * Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= n <= 8
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(3));
    }

    public List<TreeNode> generateTrees(int n) {
        return this.generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int i, int n) {
        List<TreeNode> res = new LinkedList<>();
        if (i > n) {
            res.add(null);
            return res;
        }

        for (int j = i; j < n + 1; j++) {
            List<TreeNode> leftTree = this.generateTrees(i, j-1);
            List<TreeNode> rightTree = this.generateTrees(j+1, n);

            for(TreeNode left : leftTree) {
                for (TreeNode right: rightTree) {
                    TreeNode root = new TreeNode(j);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
