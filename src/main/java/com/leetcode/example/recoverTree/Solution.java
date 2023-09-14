package com.leetcode.example.recoverTree;

import com.leetcode.example.utils.TreeNode;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Example 1:
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 *
 * Example 2:
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 1000].
 * -231 <= Node.val <= 231 - 1
 *
 * Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        left.right = right;
        TreeNode p = new TreeNode(1, left, null);
        System.out.println(p);
        solution.recoverTree(p);
        System.out.println(p);
    }

    public void recoverTree(TreeNode root) {
        TreeNode [] incorrectNodes = new TreeNode[2];
        TreeNode prev = new TreeNode(-1);
        recoverTree(root, prev, incorrectNodes);
        if (incorrectNodes[0] != null && incorrectNodes[1] != null) {
            int temp = incorrectNodes[0].val;
            incorrectNodes[0].val = incorrectNodes[1].val;
            incorrectNodes[1].val = temp;
        }
    }

    private void recoverTree(TreeNode currNode, TreeNode prev, TreeNode[] incorrectNodes) {
        if (prev.right != null) {
            return;
        }

        if (currNode != null) {
            recoverTree(currNode.left, prev, incorrectNodes);
            if (prev.left != null) {
                if (currNode.val < prev.val) {
                    if (incorrectNodes[0] == null) {
                        incorrectNodes[0] = prev.left;
                        incorrectNodes[1] = currNode;
                    } else {
                        incorrectNodes[1] = currNode;
                        prev.right = new TreeNode(1);
                        return;
                    }
                }
            }
            prev.left = currNode;
            prev.val = currNode.val;
            recoverTree(currNode.right, prev, incorrectNodes);
        }
    }
}
