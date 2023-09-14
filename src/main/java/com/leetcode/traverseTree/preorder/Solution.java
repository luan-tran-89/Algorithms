package com.leetcode.traverseTree.preorder;

import com.leetcode.traverseTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Preorder Traversal
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode right = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, right);
        System.out.println(s.preorderTraversal(root));

        System.out.println(s.preorderTraversal(new TreeNode()));

        System.out.println(s.preorderTraversal(new TreeNode(1)));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                this.preorderTraversal(root.left, list);
            }
            if (root.right != null) {
                this.preorderTraversal(root.right, list);
            }
        }
    }

}
