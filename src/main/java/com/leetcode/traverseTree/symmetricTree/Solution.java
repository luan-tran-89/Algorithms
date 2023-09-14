package com.leetcode.traverseTree.symmetricTree;

import com.leetcode.traverseTree.TreeNode;

/**
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 * Follow up: Could you solve it both recursively and iteratively?
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(s.isSymmetric1(root));

        TreeNode left1 = new TreeNode(2, null, new TreeNode(3));
        TreeNode right1 = new TreeNode(2, null, new TreeNode(3));
        TreeNode root1 = new TreeNode(1, left1, right1);
        System.out.println(s.isSymmetric1(root1));
    }

    public boolean isSymmetric1(TreeNode root) {
        return root == null || this.isMirror1(root.left, root.right);
    }

    public boolean isMirror1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean isMirror1 = this.isMirror1(root1.left, root2.right);
        boolean isMirror2 = this.isMirror1(root1.right, root2.left);
        return isMirror1 && isMirror2;
    }


    public boolean isSymmetric(TreeNode root) {
        return root == null || this.isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean isMirror1 = this.isMirror(root1.left, root2.right);
        boolean isMirror2 = this.isMirror(root1.right, root2.left);
        return isMirror1 && isMirror2;
    }
}
