package com.leetcode.example.kokoEatingBananas;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 * 875. Koko Eating Bananas
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 *
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 *
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 * Constraints:
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] piles = {3,6,7,11};
        System.out.println(solution.minEatingSpeed(piles, 8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length - 1];

        while (left < right) {
            int hourSpend = 0;
            int middle = (right + left)/2;

            for (int pile : piles) {
                hourSpend += Math.ceil((double) pile/middle);
            }

            if (hourSpend <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }

}
