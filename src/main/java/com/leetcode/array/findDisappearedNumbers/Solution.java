package com.leetcode.array.findDisappearedNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * 448. Find All Numbers Disappeared in an Array
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(solution.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int index = nums[i] * (nums[i] > 0 ? 1 : -1) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }

        return result;
    }
}
