package com.leetcode.traverseTree.constructBinaryTree.InAndPost;

import com.leetcode.traverseTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        System.out.println(s.buildTree(inorder, postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return this.helper(map, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(Map<Integer, Integer> map, int[] postorder, int inLeft, int inRight, int poLeft, int poRight) {
        if (inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[poRight]);
        int inMid = map.get(root.val);

        root.left = this.helper(map, postorder, inLeft, inMid - 1, poLeft, poLeft + inMid - inLeft - 1);
        root.right = this.helper(map, postorder, inMid + 1, inRight, poRight - inRight + inMid, poRight - 1);

        return root;
    }
}
