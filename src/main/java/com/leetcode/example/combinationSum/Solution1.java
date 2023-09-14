package com.leetcode.example.combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gasieugru
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] candidates = {2,3,6,7};
        System.out.println(solution.combinationSum(candidates, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        this.combinationSum(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void combinationSum(List<List<Integer>> result, int[] candidates, int target, int i, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || i >= candidates.length) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            list.add(candidates[j]);
            this.combinationSum(result, candidates, target - candidates[j], j, list);
            list.remove(list.size() - 1);
        }
    }
}
