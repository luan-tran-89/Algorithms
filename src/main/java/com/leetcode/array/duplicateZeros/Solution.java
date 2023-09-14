package com.leetcode.array.duplicateZeros;

import java.util.Arrays;

/**
 * Duplicate Zeros
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 *
 * Example 1:
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Example 2:
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 * Constraints:
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 9
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] input = {1,0,2,3,0,4,5,0};
//        solution.duplicateZeros(input);
//        System.out.println(Arrays.toString(input));

        int[] input1 = {1,5,2,0,6,8,0,6,0};
        solution.duplicateZeros(input1);
        System.out.println(Arrays.toString(input1));
    }

    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        int i = 0;
        int j = 0;

        while (j < length) {
            if (arr[i] == 0) {
                result[j++] = 0;
                if (j == length) {
                    break;
                }
                result[j++] = 0;
                i++;
            } else {
                result[j++] = arr[i++];
            }
        }

        for (i = 0; i < length - 1; i++) {
            arr[i] = result[i];
        }
    }
}
