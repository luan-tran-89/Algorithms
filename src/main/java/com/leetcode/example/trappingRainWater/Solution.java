package com.leetcode.example.trappingRainWater;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
    }

    public int trap(int[] height) {
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int max = height[0];
        int result = 0;

        for (int i = 0; i < length; i++) {
            left[i] = Math.max(max, height[i]);
            max = left[i];
        }

        max = height[length - 1];

        for (int i = length - 1; i >= 0; i--) {
            right[i] = Math.max(max, height[i]);
            max = right[i];
        }

        for (int i = 0; i < length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

}
