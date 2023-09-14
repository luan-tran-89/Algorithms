package com.leetcode.array.validMountainArray;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {0,3,2,1};
        System.out.println(solution.validMountainArray(input));

//        int[] input1 = {9,8,7,6,5,4,3,2,1,0};
//        System.out.println(solution.validMountainArray(input1));
    }

    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        if (length < 3 || arr[0] > arr[1]) {
            return false;
        }
        boolean isIncreased = true;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }

            if (arr[i] > arr[i + 1]) {
                if (isIncreased) {
                    isIncreased = false;
                }
            }

            if (arr[i] < arr[i + 1] && !isIncreased) {
                return false;
            }
        }

        if (arr[length - 2] >= arr[length - 1] && isIncreased) {
            return false;
        }

        return !isIncreased;
    }
}
