package com.leetcode.traverseTree.postorder;

import com.leetcode.traverseTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * @author gasieugru
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode right = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, right);
        System.out.println(s.postorderTraversal(root));

        System.out.println(s.postorderTraversal(new TreeNode()));

        System.out.println(s.postorderTraversal(new TreeNode(1)));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.postorderTraversal(root, result);
        return result;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            this.postorderTraversal(root.left, list);
            this.postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }
}
