package com.leetcode.others.kthSmallestNode;

import com.leetcode.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode left = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null);
        TreeNode right = new TreeNode(6, null, null);
        TreeNode root = new TreeNode(5, left, right);

        // 3
        System.out.println(s.kthSmallest(root, 3));
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        this.helper(root, list);
        return list.get(k - 1);
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        this.helper(root.left, list);
        list.add(root.val);
        this.helper(root.right, list);
    }

}
