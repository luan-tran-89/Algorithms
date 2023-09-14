package com.leetcode.example.medianOfTwoSortedArrays;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
        System.out.println(solution.findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] merged = new int[length];
        int n = length1 > length2 ? length1 : length2;

        System.arraycopy(nums1, 0, merged, 0, length1);
        System.arraycopy(nums2, 0, merged, length1, length2);
        Arrays.sort(merged);
        double result = 0;
        if (length % 2 == 0) {
            result = (merged[length/2] + merged[(length/2) - 1])/2.0;
        } else {
            result = merged[length/2];
        }

        return result;
    }

}
