package com.leetcode.array.removeDuplicates;

import java.util.Arrays;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,0,1,1,1,2,2,3,3,4,4,4};

        System.out.println(solution.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] arr) {
        int length = arr.length;
        if (length == 0 || length == 1) {
            return length;
        }

        int j = 0;

        for (int i = 0; i < length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }

        arr[j++] = arr[length - 1];

        for (int i = j ; i < length; i++) {
            arr[i] = -1;
        }

        return j;
    }

}
