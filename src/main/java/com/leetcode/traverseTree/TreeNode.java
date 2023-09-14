package com.leetcode.traverseTree;

/**
 *  Definition for a binary tree node.
 *
 * @author gasieugru
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public void printValue() {
        String value = "TreeNode{" +
                "val=" + val +
                '}';
        System.out.println(value);
    }
}
