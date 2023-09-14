package com.leetcode.array.checkIfExist;

/**
 * Check If N and Its Double Exist
 *
 * Given an array arr of integers, check if there exist two indices i and j such that :
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 *
 * Example 2:
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 *
 * Constraints:
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1000,2,5,3, -500};
        System.out.println(solution.checkIfExist(arr));
    }

    public boolean checkIfExist(int[] arr) {
        boolean[] map = new boolean[2001];

        for (int n : arr) {
            int index = 1000 + 2 * n;

            if (index >= 0 && index < map.length && map[index]) {
                return true;
            }

            if (n%2 == 0 && map[1000 + n/2]) {
                return true;
            }

            map[1000 + n] = true;
        }

        return false;
    }
}
