package com.interview.pi;

import java.util.*;

/**
 * Given a list of employees where each is assigned a numeric evaluation score,
 * use the selection process below to find the sum of scores of selected employees.
 * 1 The employee with the highest score among the first k employees or the last k employees in the score list is selected.
 * 2. The selected employee is removed from the score list. .
 * 3 The process continues to select the next employee until the team_size is achieved.
 *
 * Note:
 * 1. In case multiple employees have the same highest score, the employee with the lowest index si selected.
 * 2. Ift h e r e are fewer than k employees, the entire list si available for selection.
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
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        // 50
//        int[] score = {10, 20, 10, 15, 5, 30, 20};
//        System.out.println(solution.teamFormation(score, 2, 3));
//
////        // 20 + 17 + 12 = 49.
//        int[] input1 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
//        System.out.println(solution.teamFormation(input1, 3, 4));
//
//        // 18 + 7 + 9 + 15 + 11 = 60 .
//        int[] input2 = {18, 5, 15, 18, 11, 15, 9, 7};
//        System.out.println(solution.teamFormation(input2, 5, 1));
//
////        // 20 + 17 + 12 = 49
//        int[] input3 = {17, 12, 10, 2, 7, 2, 11, 20, 11, 8};
//        System.out.println(solution.teamFormation(input3, 3, 4));
//
//        // 20 + 17 + 12 + 11 = 60
//        int[] input4 = {17, 12, 10, 2, 7, 2, 11, 20, 11, 8};
//        System.out.println(solution.teamFormation(input4, 4, 4));
//
//        //
//        int[] input5 = {6,18,8,14,10,12,18,9};
//        System.out.println(solution.teamFormation(input5, 80, 3));
//
//        int[] input6 = {18,5,15,18,11,15,9,7};
//        System.out.println(solution.teamFormation(input6, 5, 1));


        int[] input7 = {6,18,8,14,10,12,18,9};
        System.out.println(solution.teamFormation(input7, 1, 3));
    }

    public int teamFormation(int[] scores, int teamSize, int k) {
        int cost = 0;
        int n = scores.length;

        if(n - teamSize < k * 2) {
            Arrays.sort(scores);
            for(int i = n - 1; i >= n - teamSize && i >= 0; i--) {
                cost += scores[i];
            }
        } else {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int i = 0, j = n - 1, c = 0;

            while(c++ < k) {
                pq.offer(new int[] {scores[j--], 1});
                pq.offer(new int[] {scores[i++], 2});
            }

            while(teamSize-- > 0) {
                int[] cur = pq.poll();
                cost += cur[0];
                if(cur[1] == 1)	{
                    pq.offer(new int[] {scores[j--], 1});
                } else {
                    pq.offer(new int[] {scores[i++], 2});
                }
            }
        }

        return cost;
    }

}
