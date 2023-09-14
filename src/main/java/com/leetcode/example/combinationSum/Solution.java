package com.leetcode.example.combinationSum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/combination-sum/
 * 39. Combination Sum
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 *
 * The com.test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 *
 * Constraints:
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2,3,6,7};
        System.out.println(solution.combinationSum(candidates, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        this.combinationSum(result, candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void combinationSum(List<List<Integer>> result, int[] candidates, int i, int target, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            int value = candidates[j];
            list.add(value);
            this.combinationSum(result, candidates, j, target - value, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = Arrays.stream(candidates).boxed().collect(Collectors.toList());

        for (int i=0; i<length; i++) {
            int value = candidates[i];
            if (value > target) {
                continue;
            }

            this.getCombinationSum(list, result, new ArrayList<>(), value, target);
        }

        return result;
    }

    private void getCombinationSum(List<Integer> candidates, List<List<Integer>> result, List<Integer> list, int value, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        } else if (target == value) {
            list.add(target);
            result.add(new ArrayList<>(list));
            return;
        } else if (target < value) {
            if (candidates.contains(target)) {
                list.add(target);
                result.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(value);
        this.getCombinationSum(candidates, result, list, value, target - value);
    }

}
