package com.leetcode.traverseTree.maximunDepth;

import com.leetcode.traverseTree.TreeNode;

/**
 * @author gasieugru
 */
public class Solution {
    private static int answer;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode left = new TreeNode(9, null, null);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(solution.getMaxDepth(root));

        answer = 0;
        solution.getMaxDepth(root, 1);
        System.out.println(answer);
    }

    public int getMaxDepth(TreeNode root) {
//        return this.getMaxDepth(root, 1);
        if (root == null) {
            return 0;
        }

        int maxLeft = getMaxDepth(root.left);
        int maxRight = getMaxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

    public void getMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        getMaxDepth(root.left, depth + 1);
        getMaxDepth(root.right, depth + 1);
    }
}
