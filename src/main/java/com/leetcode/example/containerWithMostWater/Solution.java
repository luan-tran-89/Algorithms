package com.leetcode.example.containerWithMostWater;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(heights));
    }

    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;

        if (length < 2) {
            return maxArea;
        }

        int begin = 0;
        int end = length - 1;
        while (begin < end) {
            int first = height[begin];
            int last = height[end];
            maxArea = Math.max(maxArea, Math.min(first, last) * (end - begin));
            if (first < last) {
                begin++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
