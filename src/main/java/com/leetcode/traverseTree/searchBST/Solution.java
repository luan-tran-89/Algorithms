package com.leetcode.traverseTree.searchBST;

import com.leetcode.traverseTree.TreeNode;

/**
 * Search in a Binary Search Tree
 *
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 *
 * Example 1:
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 *
 * Example 2:
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode right = new TreeNode(7, null, null);
        TreeNode root = new TreeNode(4, left, right);
        System.out.println(s.searchBST(root, 2));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode node;

        if (root.val >= val) {
            node = this.searchBST(root.left, val);
        } else {
            node = this.searchBST(root.right, val);
        }

        return node;
    }
}
