package com.leetcode.traverseTree.pathSum;

import com.leetcode.traverseTree.TreeNode;

/**
 *
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such
 * that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 *
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 *
 * Example 3:
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        TreeNode right = new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)));
        TreeNode root = new TreeNode(5, left, right);

//        System.out.println(s.hasPathSum(root, 22));

        TreeNode root1 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(s.hasPathSum(root1, 0));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return this.hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == sum) {
                return true;
            }
        }

        boolean isLeftHasPathSum = this.hasPathSum(root.left, targetSum, sum);
        boolean isRightHasPathSum = this.hasPathSum(root.right, targetSum, sum);
        return isLeftHasPathSum || isRightHasPathSum;
    }
}
