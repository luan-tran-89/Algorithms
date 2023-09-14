package com.leetcode.example.searchInsert;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5));
    }

    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - target >= 0) {
                return i;
            }
            if (i == nums.length - 1) {
                return nums.length;
            }
        }

        return 0;
    }
}
