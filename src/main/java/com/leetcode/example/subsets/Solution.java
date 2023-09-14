package com.leetcode.example.subsets;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 * 78. Subsets
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {4,4,4,1,4};
        System.out.println(solution.subsets(candidates));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        this.subsets(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void subsets(List<List<Integer>> result, int[] nums, int i, List<Integer> list) {
        if (i == nums.length) {
            List<Integer> value = new ArrayList<>(list);
            Collections.sort(value);
            if (!result.contains(value)) {
                result.add(value);
            }
            return;
        }

        list.add(nums[i]);
        this.subsets(result, nums, i+1, list);
        list.remove(list.size() -1);
        this.subsets(result, nums, i+1, list);
    }

}
