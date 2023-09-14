package com.algo.lab5.isSelfAware;

/**
 * An array A of size n is self-aware if, for each i < n, A[i] is the exact number of occurrences of i in A.
 * Example:A = [2, 0, 2, 0]
 * Explanation:
 *      A[0] = 2 and A contains two occurrences of 0.
 *      A[1] = 0 and A contains 0 occurrences of 1.
 *      A[2] = 2 and A contains two occurrences of 2.
 *      A[3] = 0 and A contains 0 occurrences of 3.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2, 0, 2, 0};
        System.out.println(s.isSelfAware(arr));
    }

    public static boolean isSelfAware(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int length = arr.length;
        int[] temp = new int[length];

        for (int i = 0; i < length; i++) {
            if (arr[i] >= length) {
                return false;
            }
            temp[arr[i]]++;
        }

        for (int i = 0; i < length; i++) {
            if (temp[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}
