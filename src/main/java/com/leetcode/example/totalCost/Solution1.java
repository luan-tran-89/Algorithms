package com.leetcode.example.totalCost;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author gasieugru
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] cost = {17,12,10,2,7,2,11,20,8};
        System.out.println(solution.totalCost(cost, 3, 4));

//        int[] cost1 = {1,2,4,1};
//        System.out.println(solution.totalCost(cost1, 3, 3));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        int n = costs.length;

        if(n - k < candidates * 2) {
            Arrays.sort(costs);
            for(int i = 0; i < k; i++) {
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
