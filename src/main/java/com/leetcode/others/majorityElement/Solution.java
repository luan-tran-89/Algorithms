package com.leetcode.others.majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 * 169. Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.majorityElement(new int[]{3, 2, 3}));
        System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

}
