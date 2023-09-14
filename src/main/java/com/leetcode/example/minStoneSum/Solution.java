package com.leetcode.example.minStoneSum;

import java.util.*;

/**
 * You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k.
 * You should apply the following operation exactly k times:
 *
 * Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
 * Notice that you can apply the operation on the same pile more than once.
 *
 * Return the minimum possible total number of stones remaining after applying the k operations.
 *
 * floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).
 *
 * Example 1:
 * Input: piles = [5,4,9], k = 2
 * Output: 12
 * Explanation: Steps of a possible scenario are:
 * - Apply the operation on pile 2. The resulting piles are [5,4,5].
 * - Apply the operation on pile 0. The resulting piles are [3,4,5].
 * The total number of stones in [3,4,5] is 12.
 *
 * Example 2:
 * Input: piles = [4,3,6,7], k = 3
 * Output: 12
 * Explanation: Steps of a possible scenario are:
 * - Apply the operation on pile 2. The resulting piles are [4,3,3,7].
 * - Apply the operation on pile 3. The resulting piles are [4,3,3,4].
 * - Apply the operation on pile 0. The resulting piles are [2,3,3,4].
 * The total number of stones in [2,3,3,4] is 12.
 *
 * Constraints:
 * 1 <= piles.length <= 10^5
 * 1 <= piles[i] <= 10^4
 * 1 <= k <= 10^5
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minStoneSum(new int[]{5,4,9}, 2));

    }

    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        int a[] = new int[10001];
        for (int i : piles) {
            sum += i;
            a[i]++;
        }
        for (int i = 10000; i > 0 && k > 0; i--) {
            if (a[i] > 0) {
                int b = i / 2;
                sum -= Math.min(k, a[i]) * b;
                a[i - i / 2] += a[i];
                k -= a[i];
            }
        }
        return sum;

    }

    public int minStoneSum2(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            queue.add(pile);
        }

        for (int i = 0; i < k; i++) {
            int value = queue.remove();
            int newValue = value - (value/2);
            queue.add(newValue);
        }

        for (int value : queue) {
            sum += value;
        }

        return sum;
    }

    public int minStoneSum1(int[] piles, int k) {
        Arrays.sort(piles);
        int sum = 0;

        int i = piles.length - 1;
        while (i>=0) {
            int removedValue = k > 0 ? (int) Math.floor(piles[i]/2) : 0;
            piles[i] = piles[i] - removedValue;
            Arrays.sort(piles);
            if (k <= 0) {
                sum += piles[i];
                i--;
            }
            k--;
        }

        return sum;
    }
}
