package com.leetcode.example.longestConsecutive;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] input = {100,4,200,1,3,2};
//        int[] input = {1,2,0,1};
        System.out.println(s.longestConsecutive(input));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return nums.length;
        }
        int result = 1;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while(set.contains(num + 1)) {
                    count++;
                    num++;
                }
                result = Math.max(result, count);
            }
        }

        return result;
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = 1;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                result = Math.max(result, count);
            }
        }

        return result;
    }
}
