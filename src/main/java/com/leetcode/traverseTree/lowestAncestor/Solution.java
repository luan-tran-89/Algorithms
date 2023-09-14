package com.leetcode.traverseTree.lowestAncestor;

import com.leetcode.traverseTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode left = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, left, right);

        TreeNode result = s.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(5));
        System.out.println(result.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        if (!this.findPath(root, p.val, path1) ||
            !this.findPath(root, q.val, path2)
        ) {
            return null;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i).val != path2.get(i).val) {
                break;
            }
        }

        return path1.get(i - 1);
    }

    private boolean findPath(TreeNode root, int value, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.val == value ||
            this.findPath(root.left, value, path) ||
            this.findPath(root.right, value, path)
        ) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }
}
