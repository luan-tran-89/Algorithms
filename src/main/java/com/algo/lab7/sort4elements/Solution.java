package com.algo.lab7.sort4elements;

import java.util.Arrays;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {5, 9, 1, 3};
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        if (arr[0] > arr[1]) {
            swap(arr, 0, 1);
        }
        if (arr[2] > arr[3]) {
            swap(arr, 2, 3);
        }
        if (arr[0] > arr[2]) {
            swap(arr, 0, 2);
        }
        if (arr[1] > arr[3]) {
            swap(arr, 1, 3);
        }
        if (arr[1] > arr[2]) {
            swap(arr, 1, 3);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
