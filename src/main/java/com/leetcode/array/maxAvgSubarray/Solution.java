package com.leetcode.array.maxAvgSubarray;

/**
 * 643. Maximum Average Subarray I
 * https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 *
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 * Constraints:
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1,12,-5,-6,50,3};
//        System.out.println(s.findMaxAverage(nums, 4));

        int[] nums1 = {5};
        System.out.println(s.findMaxAverage(nums1, 1));

//        System.out.println(s.getAverageArray(nums, 1, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length <= 1) {
            return nums[0];
        }

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return (double) maxSum / k;
    }

}
