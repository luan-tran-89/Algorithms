package com.leetcode.example.isValidBST;

import com.leetcode.example.utils.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 98. Validate Binary Search Tree
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();


        TreeNode left1 = new TreeNode(0);
        TreeNode left2 = new TreeNode(2);
        TreeNode left = new TreeNode(1, left1, left2);

        TreeNode right1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(6);
        TreeNode right = new TreeNode(5, right1, right2);
        TreeNode p = new TreeNode(3, left, right);
        System.out.println(solution.isValidBST(p));
    }

    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!this.isValidBST(root.left)) {
                return false;
            }

            if (prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;

            return this.isValidBST(root.right);
        }

        return true;
    }
}
