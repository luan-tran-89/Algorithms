package com.leetcode.example.combinationSumII;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * Constraints:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(solution.combinationSum2(candidates, 30));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        this.combinationSum(result, candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void combinationSum(List<List<Integer>> result, int[] candidates, int i, int target, List<Integer> list) {
        if (target == 0) {
            List<Integer> sum = new ArrayList<>(list);
            Collections.sort(sum);
            if (!result.contains(sum)) {
                result.add(sum);
            }
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            int value = candidates[j];
            if (j > i && value == candidates[j - 1]) {
                continue;
            }
            list.add(value);
            this.combinationSum(result, candidates, j+1, target - value, list);
            list.remove(list.size() - 1);
        }
    }

}
