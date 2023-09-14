package com.leetcode.traverseTree.validateBST;

import com.leetcode.traverseTree.TreeNode;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(2, left, right);
        System.out.println(s.isValidBST(root));

        TreeNode left1 = new TreeNode(1,  null, null);
        TreeNode right1 = new TreeNode(4, new TreeNode(3), new TreeNode(6));
        TreeNode root1 = new TreeNode(5, left1, right1);
        System.out.println(s.isValidBST(root1));

        System.out.println(Integer.MAX_VALUE);
        System.out.println((int) Math.pow(2, 31) - 1);
    }

    public boolean isValidBST(TreeNode root) {
        return this.helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (val <= min || val >= max) {
            return false;
        }

        return helper(root.left, min, val) && helper(root.right, val, max);
    }

}
