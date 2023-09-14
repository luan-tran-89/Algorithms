package com.leetcode.example.totalCost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2462. Total Cost to Hire K Workers
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/
 *
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] cost = {17,12,10,2,7,2,11,20,8};
//        System.out.println(solution.totalCost(cost, 3, 4));

        int[] cost1 = {1,2,4,1};
        System.out.println(solution.totalCost(cost1, 3, 3));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        return this.teamFormation(costs, k, candidates);
    }

    public int teamFormation(int[] score, int teamSize, int k) {
        List<Integer> scores = Arrays.stream(score).boxed().collect(Collectors.toList());
        List<Integer> selectedScores = new ArrayList<>();

        while (teamSize > 0) {
            if (scores.size() <= k) {
                int selectedScore = Collections.min(scores);
                selectedScores.add(selectedScore);
                scores.remove(Integer.valueOf(selectedScore));
            } else {
                List<Integer> beginList = scores.subList(0, k);
                List<Integer> endList = scores.subList(scores.size() - k, scores.size());
                int minStart = Collections.min(beginList);
                int minEnd = Collections.min(endList);

                // 17,12,10,2,7,2,11,20,8
                if (minStart <= minEnd) {
                    selectedScores.add(minStart);
                    scores.remove(Integer.valueOf(minStart));
                } else {
                    int removeIndex = scores.size() - k + endList.indexOf(minEnd);
                    selectedScores.add(scores.get(removeIndex));
                    scores.remove(removeIndex);
                }
            }
            teamSize--;
        }
        return selectedScores.stream().mapToInt(Integer::intValue).sum();
    }
}
