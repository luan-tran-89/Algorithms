package com.leetcode.traverseTree.constructBinaryTree.preAndIn;

import com.leetcode.traverseTree.TreeNode;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Given two integer arrays preorder and inorder
 * where preorder is the preorder traversal of a binary tree and inorder
 * is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        System.out.println(s.buildTree(preorder, inorder));
    }

    private int i = 0;
    private int p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return this.helper(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            return null;
        }

        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode root = new TreeNode(preorder[p++]);
        root.left = this.helper(preorder, inorder, root.val);
        root.right = this.helper(preorder, inorder, stop);

        return root;
    }

}
