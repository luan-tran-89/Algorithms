package com.leetcode.totalCostToHire;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2462. Total Cost to Hire K Workers
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
 *
 * You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
 *
 * You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
 *
 * - You will run k sessions and hire exactly one worker in each session.
 *      In each hiring session, choose the worker with the lowest cost
 *      from either the first candidates workers or the last candidates workers.
 *      Break the tie by the smallest index.
 *
 *      - For com.example, if costs = [3,2,7,7,1,2] and candidates = 2,
 *      then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
 *      - In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker
 *      but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
 * - If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them.
 *      Break the tie by the smallest index.
 * - A worker can only be chosen once.
 * Return the total cost to hire exactly k workers.
 *
 * Example 1:
 * Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
 * Output: 11
 * Explanation: We hire 3 workers in total. The total cost is initially 0.
 * - In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8].
 *      The lowest cost is 2, and we break the tie by the smallest index, which is 3.
 *      The total cost = 0 + 2 = 2.
 * - In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8].
 *      The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
 * - In the third hiring round we choose the worker from [17,12,10,7,11,20,8].
 *      The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11.
 *      Notice that the worker with index 3 was com.common in the first and last four workers.
 *  => The total hiring cost is 11.
 *
 * Example 2:
 * Input: costs = [1,2,4,1], k = 3, candidates = 3
 * Output: 4
 * Explanation: We hire 3 workers in total. The total cost is initially 0.
 * - In the first hiring round we choose the worker from [1,2,4,1].
 *      The lowest cost is 1, and we break the tie by the smallest index, which is 0.
 *      The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are com.common in the first and last 3 workers.
 * - In the second hiring round we choose the worker from [2,4,1].
 *      The lowest cost is 1 (index 2).
 *      The total cost = 1 + 1 = 2.
 * - In the third hiring round there are less than three candidates.
 *      We choose the worker from the remaining workers [2,4].
 *      The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
 * => The total hiring cost is 4.
 *
 * Constraints:
 * 1 <= costs.length <= 10^5
 * 1 <= costs[i] <= 10^5
 * 1 <= k, candidates <= costs.length
 *
 * @author gasieugru
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        int[] cost = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;

        System.out.println(solution.totalCost(cost, k, candidates));
        int[] cost2 = {17,12,10,2,7,10,2,7,10,2,7,2,11,20,8};
        System.out.println(solution.totalCost(cost2, k, candidates));
//
        int[] cost1 = {1,2,4,1};
        System.out.println(solution.totalCost(cost1, 3, 3));

        int[] input3 = {6,18,8,14,10,12,18,9};
        System.out.println(solution.totalCost(input3, 1, 3));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;

        int n = costs.length;

        if(n - k < candidates * 2) {
            Arrays.sort(costs);
            for(int i = 0; i < k; i++)	{
                cost += costs[i];
            }
        } else {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            int i = 0, j = n - 1, c = 0;

            while(c++ < candidates) {
                pq.offer(new int[] {costs[i++], 1});
                pq.offer(new int[] {costs[j--], 2});
            }

            while(k-- > 0) {
                int[] cur = pq.poll();
                cost += cur[0];

                if(cur[1] == 1)	{
                    pq.offer(new int[] {costs[i++], 1});
                } else {
                    pq.offer(new int[] {costs[j--], 2});
                }
            }
        }

        return cost;
    }
}
