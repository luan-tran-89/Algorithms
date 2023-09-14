package com.algo.lab7.arrangeArray;

import com.algo.lab4.sort.sortroutines.MergeSort;

import java.util.Arrays;

/**
 * @author gasieugru
 */
public class Solution {
    MergeSort mergeSort = new MergeSort();

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 2, 17, -4, -6, 8};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output: " + Arrays.toString(s.arrangeArray(arr)));
    }

    public int[] arrangeArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        mergeSort.sort(arr);

        for (int i = 0; i < n; i++) {
            res[i] = i%2 == 0 ? arr[i/2] : arr[n - 1 - (i/2)];
        }

        return res;
    }

}
