package com.leetcode.array.mergeArray;

import java.util.Arrays;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 4, 5, 8, 17};
        int[] B = new int[]{2, 4, 8, 11, 13, 21, 23, 25};
        int[] C = merge(A,B);
        System.out.println(Arrays.toString(C));
    }

    private static int[] merge(int[] A, int[] B) {
        int ALength = A.length;
        int BLength = B.length;
        int CLength = ALength + BLength;
        int[] C = new int[CLength];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < ALength && j < BLength) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while(i < ALength) {
            C[k++] = A[i++];
        }

        while(j < BLength) {
            C[k++] = B[j++];
        }

        return C;
    }
}
