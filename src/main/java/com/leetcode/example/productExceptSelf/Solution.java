package com.leetcode.example.productExceptSelf;

import java.util.*;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        StringBuilder str = new StringBuilder("anagram");
        String a = str.reverse().toString();

        Set<Character> str1 = new TreeSet<>("nagaram".chars().mapToObj(c -> (char) c).sorted().toList());

//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int right = 1, left = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i];
        }
        // input: [1,,3,4]
        // => [1,1,2,6]
        // => [1,1,8,6]
        // => [1,12,8,6]
        // => [24,12,8,6]

        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }
        return arr;
    }
}
