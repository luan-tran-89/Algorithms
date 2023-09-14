package com.interview.pi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/discuss/interview-question/428228/Team-Formation-(Audible-online-assessment-)
 *
 * https://www.chegg.com/homework-help/questions-and-answers/hacker-industries-number-employees-company-assigns-employee-numeric-evaluation-score-store-q80887874
 *
 * Given a list of employees where each is assigned a numeric evaluation score,
 * use the selection process below to find the sum of scores of selected employees.
 * 1 The employee with the highest score among the first k employees or the last k employees in the score list is selected.
 * 2. The selected employee is removed from the score list. .
 * 3 The process continues to select the next employee until the team_size is achieved.
 *
 * Note:
 * 1. In case multiple employees have the same highest score, the employee with the lowest index si selected.
 * 2. If there are fewer than k employees, the entire list si available for selection.
 *
 * Example
 *      score = (10, 20, 10, 15, 5, 30, 20]
 *      teamSize= 2
 *      K=3
 *      - For thefirst selection, choose from the first 3elements: [10, 20, 10]or the last 3elements: (5, 30, 20].
 *          Score 30si selected and removed from the list. This makes score= [10, 20, 10, 15, 5, 201.
 *      - For the second selection, choose from [10, 20, 10]or [15, 5, 20].
 *          Score 20i s selected from the lowest index and removed from the list. This makes score =[10, 10, 15, 5, 20].
 *      - The sum of the selected employees' scores si 30 +20 =50.
 *
 * Function Description:
 *  Complete the function teamFormationin the editor below.
 *  teamFormation has het following parameter(s):
 *      score[n): an array of scores for each employee
 *      team_size: the number of team members required
 *      k: the size of the array segments to select from
 *  Returns:
 *  int: the sum of the scores of al members selected for the team
 *
 * Constraints
 *  • 1 ≤ n <= 10^5
 *  • 1 ≤ score[i] <= 10^9
 *  • 1 <= steam_sizes <= n
 *  • 1 <= k <= n
 *
 * com.test.Test cases:
 *  1. score = [17, 12, 10, 2, ,7 2, 11, 20, 8].
 *      team_size = 3
 *      k = 4
 *      => Output = 20 + 17 + 12 = 49
 *
 *  2. score = [18, 5, 15, 18, 11, 15, 9, 7].
 *      team_size = 5
 *      k = 1
 *      => Output = 18 + 7 + 9 + 15 + 11 = 60
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 50
        int[] score = {10, 20, 10, 15, 5, 30, 20};
        System.out.println(solution.teamFormation(score, 2, 3));

        // 20 + 17 + 12 = 49.
        int[] input1 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        System.out.println(solution.teamFormation(input1, 3, 4));

//        // 18 + 7 + 9 + 15 + 11 = 60 .
        int[] input2 = {18, 5, 15, 18, 11, 15, 9, 7};
        System.out.println(solution.teamFormation(input2, 5, 1));

        // 20 + 17 + 12 + 11 = 60
        int[] input3 = {17, 12, 10, 2, 7, 2, 11, 20, 11, 8};
        System.out.println(solution.teamFormation(input3, 4, 4));

        // 18
        int[] input7 = {6,18,8,14,10,12,18,9};
        System.out.println(solution.teamFormation(input7, 1, 3));

        // 18
        int[] input8 = {6};
        System.out.println(solution.teamFormation(input8, 3, 3));

//        int length = (int) Math.pow(10, 5);
//        int[] score1 = new int[length];
//        Arrays.fill(score1, 1);
//        System.out.println(solution.teamFormation(score1, 60000, 20000));

//        System.out.println(solution.teamFormation(Arrays.stream(score).boxed().collect(Collectors.toList()), 2, 3));
//        System.out.println(solution.teamFormation(Arrays.stream(input1).boxed().collect(Collectors.toList()), 3, 4));
//        System.out.println(solution.teamFormation(Arrays.stream(input2).boxed().collect(Collectors.toList()), 5, 1));
    }

    public int teamFormation(int[] score, int teamSize, int k) {
        int result = 0;
        int length = score.length;

        if (length - teamSize < 2 * k) {
            Arrays.sort(score);
            int index = Math.max(0, length - teamSize);
            for (int i = length - 1; i >= index; i--) {
                result += score[i];
            }
        } else {
            List<Integer> scores = Arrays.stream(score).boxed().collect(Collectors.toList());
            List<Integer> selectedScores = new ArrayList<>();

            while (selectedScores.size() < teamSize) {
                if (scores.size() <= k) {
                    int selectedScore = Collections.max(scores);
                    selectedScores.add(selectedScore);
                    scores.remove(Integer.valueOf(selectedScore));
                } else {
                    List<Integer> beginList = scores.subList(0, k);
                    List<Integer> endList = scores.subList(scores.size() - k, scores.size());
                    int maxStart = Collections.max(beginList);
                    int maxEnd = Collections.max(endList);
                    if (maxStart >= maxEnd) {
                        selectedScores.add(maxStart);
//                        scores.remove(Integer.valueOf(maxStart));
                        scores.remove(beginList.indexOf(maxStart));
                    } else {
                        int removeIndex = scores.size() - k + endList.indexOf(maxEnd);
                        selectedScores.add(scores.get(removeIndex));
                        scores.remove(removeIndex);
                    }
                }
            }
            result = selectedScores.stream().mapToInt(Integer::intValue).sum();
        }

        return result;
    }

    public static int teamFormation(List<Integer> scores, int teamSize, int k) {
        List<Integer> selectedScores = new ArrayList<>();
        while (teamSize > 0) {
            if (scores.size() <= k) {
                int selectedScore = Collections.max(scores);
                selectedScores.add(selectedScore);
                scores.remove(Integer.valueOf(selectedScore));
            } else {
                List<Integer> beginList = scores.subList(0, k);
                List<Integer> endList = scores.subList(scores.size() - k, scores.size());
                int maxStart = Collections.max(beginList);
                int maxEnd = Collections.max(endList);
                if (maxStart >= maxEnd) {
                    selectedScores.add(maxStart);
                    scores.remove(Integer.valueOf(maxStart));
                } else {
                    int removeIndex = scores.size() - k + endList.indexOf(maxEnd);
                    selectedScores.add(scores.get(removeIndex));
                    scores.remove(removeIndex);
                }
            }
            teamSize--;
        }
        return selectedScores.stream().mapToInt(Integer::intValue).sum();
    }

    public static int selectEmployees(List<Integer> scores, int teamSize, int k) {
        List<Integer> selectedScores = new ArrayList<>();
        while (teamSize > 0) {
            if (scores.size() <= k) {
                int selectedScore = scores.stream().max(Integer::compare).get();
                selectedScores.add(selectedScore);
                scores.remove(Integer.valueOf(selectedScore));
            } else {
                int maxStart = scores.subList(0, k).stream().max(Integer::compare).get();
                int maxEnd = scores.subList(scores.size() - k, scores.size()).stream().max(Integer::compare).get();
                int selectedScore = Math.max(maxStart, maxEnd);
                selectedScores.add(selectedScore);
                scores.remove(Integer.valueOf(selectedScore));
            }
            teamSize--;
        }
        return selectedScores.stream().mapToInt(Integer::intValue).sum();
    }
}
