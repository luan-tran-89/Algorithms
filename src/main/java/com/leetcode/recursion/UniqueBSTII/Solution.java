package com.leetcode.recursion.UniqueBSTII;

import com.leetcode.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateTrees(3));

    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int i, int n) {
        List<TreeNode> result = new ArrayList<>();

        if (i > n) {
            result.add(null);
            return result;
        }

        for (int j = i; j <= n; j++) {
            List<TreeNode> leftTree = this.generateTrees(i, j - 1);
            List<TreeNode> rightTree = this.generateTrees(j + 1, n);
            for (TreeNode leftNode : leftTree) {
                for (TreeNode rightNode : rightTree) {
                    TreeNode root = new TreeNode(j);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
