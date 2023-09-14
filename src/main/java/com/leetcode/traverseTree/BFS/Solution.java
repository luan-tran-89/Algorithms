package com.leetcode.traverseTree.BFS;

import com.leetcode.traverseTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode left = new TreeNode(9, null, null);
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(s.levelOrder(root));

        System.out.println(s.levelOrder(new TreeNode()));
        System.out.println(s.levelOrder(new TreeNode(1)));

        TreeNode root1 = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4, null, null), null),
                new TreeNode(3, null, new TreeNode(5, null, null)));
        System.out.println(s.levelOrder(root1));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
//        if (root != null) {
//            result.add(List.of(root.val));
            this.levelOrder(root, 0, result);
//        }
        return result;
    }

    private void levelOrder(TreeNode root, int level, List<List<Integer>> result) {
        if (root != null) {
            if (result.size() == level) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
            } else {
                result.get(level).add(root.val);
            }
            this.levelOrder(root.left, level + 1, result);
            this.levelOrder(root.right, level + 1, result);
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int height = this.getHeight(root);

        for (int i = 0; i <= height; i++) {
            this.levelOrder1(root, i, result);
        }

        return result;
    }

    private int getHeight(TreeNode root) {
        if (root != null) {
            int leftHeight = this.getHeight(root.left);
            int rightHeight = this.getHeight(root.left);

            return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
        return 0;
    }

    private void levelOrder1(TreeNode root, int level, List<List<Integer>> result) {
        if (root != null) {
            if (level == 1) {
                result.add(List.of(root.val));
            } else if (level > 1) {
//                result.add(List.of(root.left.val, root.right.val));
                this.levelOrder1(root.left, level - 1, result);
                this.levelOrder1(root.right, level - 1, result);
            }
        }
    }
}
