package com.leetcode.example.mergeSortedArray;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * 88. Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 * Constraints:
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] numb1 = {1,2,3,0,0,0};
//        int[] numb2 = {2,5,6};
//        int[] numb1 = {4,5,6,0,0,0};
//        int[] numb2 = {1,2,3};
//        solution.merge(numb1, 3, numb2, 3);
        int[] numb1 = {-1,0,0,0,3,0,0,0,0,0,0};
        int[] numb2 = {-1,-1,0,0,1,2};
        solution.merge(numb1, 5, numb2, 6);
        System.out.println(Arrays.toString(numb1));
        // {-1,0,0,0,3,0,0,0,0,0,3}
        // {-1,0,0,0,3,0,0,0,0,2,3}
        // {-1,0,0,0,3,0,0,0,1,2,3}
        // {-1,0,0,0,3,0,0,0,1,2,3}
        // {-1,0,0,0,3,0,0,0,1,2,3}
        // {-1,0,0,0,0,0,0,0,1,2,3}
        // {-1,0,0,0,0,0,0,0,1,2,3}
        // {-1,0,0,0,0,0,0,0,1,2,3}
        // {-1,0,0,0,0,0,0,0,1,2,3}
        // {-1,0,-1,0,0,0,0,0,1,2,3}
        // {-1,-1,-1,0,0,0,0,0,1,2,3}
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            int value1 = nums1[i];
            if (j < n) {
                if (value1 >= nums2[j]) {
                    this.insertArray(nums1, nums2[j], i);
                    m++;
                    j++;
                }
                if (i >= m && value1 == 0) {
                    nums1[i] = nums2[j];
                    j++;
                }
            }
        }
    }

    private void insertArray(int[] arr, int key, int index) {
        int[] result = new int[arr.length];

        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (i == index) {
                result[j] = key;
                j++;
            }
            if (j < arr.length) {
                result[j] = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }
}
