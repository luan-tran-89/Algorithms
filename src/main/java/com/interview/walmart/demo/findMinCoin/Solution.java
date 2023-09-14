package com.interview.walmart.demo.findMinCoin;

import java.util.Arrays;

/**
 * It looks like the leet code 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 *
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * Find minimum number of coins that make a given value
 *
 *
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *      Input: coins = [1,2,5], amount = 11
 *      Output: 3
 *      Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *      Input:[1,2,3] ,amount=12
 *      Output: 4
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2 ,5};
        System.out.println(solution.minCoins3(coins, 11));

        System.out.println(solution.minCoins3(new int[]{1,2,3}, 12));

        System.out.println(solution.minCoins3(new int[]{9, 6, 5, 1}, 11));
        // [0,12,12,12,12,12,12,12,12,12,12,12]
        // [0,12,12,12,12,12,12,12,12,1,12,12] - 9 - 9
        // [0,12,12,12,12,12,12,12,12,1,12,12] - 9 - 10
        // [0,12,12,12,12,12,12,12,12,1,12,12] - 9 - 11
        // [0,12,12,12,12,12,1,12,12,1,12,12] - 6 - 6
        // [0,12,12,12,12,12,1,12,12,1,12,12] - 6 - 7
        // ...
        // [0,12,12,12,12,12,1,12,12,1,12,12] - 6 - 11
        // [0,12,12,12,12,1,1,12,12,1,12,1] - 5 - 5
        // [0,12,12,12,12,1,1,12,12,1,12,1] - 5 - 6
        // ...
        // [0,12,12,12,12,1,1,12,12,1,1,1] - 5 - 10
        // [0,12,12,12,12,1,1,12,12,1,2,2] - 5 - 11
        // [0,1,12,12,12,1,1,12,12,1,2,2] - 1 - 1
        // [0,1,2,12,12,1,1,12,12,1,2,2] - 1 - 2
        // [0,1,2,3,12,1,1,12,12,1,2,2] - 1 - 3
        // [0,1,2,3,4,1,1,12,12,1,2,2] - 1 - 4
        // [0,1,2,3,4,1,1,12,12,1,2,2] - 1 - 5
        // [0,1,2,3,4,1,1,12,12,1,2,2] - 1 - 6
        // [0,1,2,3,4,1,1,2,12,1,2,2] - 1 - 7
        // [0,1,2,3,4,1,1,2,3,1,2,2] - 1 - 8
        // [0,1,2,3,4,1,1,2,3,1,2,2] - 1 - 9
        // [0,1,2,3,4,1,1,2,3,1,2,2] - 1 - 10
        // [0,1,2,3,4,1,1,2,3,1,2,2] - 1 - 11


        System.out.println(solution.minCoins3(new int[]{2,5}, 3));
    }

    public int minCoins3(int coins[], int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;

        // O(n * m)
        for (int coin : coins) {    // n
            for (int i = coin; i <= target; i++) {  // m
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[target] > target ? - 1 : dp[target];
    }

    public int minCoins2(int coins[], int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int subRes = dp[i - coins[j]];
                    if (subRes != Integer.MAX_VALUE && subRes + 1 < dp[i]) {
                        dp[i] = subRes + 1;
                    }
                }
            }
        }
        if (dp[target] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[target];
    }

    public int minCoins(int coins[], int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return this.helper(coins, target, dp);
    }

    private int helper(int coins[], int target, int[] dp) {
        if (target == 0) {
            return 0;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= target) {
                int value = this.helper(coins, target - coins[i], dp);
                if (value != Integer.MAX_VALUE && value + 1 < result) {
                    result = value + 1;
                }
            }
        }

        dp[target] = result;


        return result == Integer.MAX_VALUE ? - 1 : result;
    }


    public int minCoins1(int coins[], int target) {
        if (target == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= target) {
                int value = this.minCoins1(coins, target - coins[i]);
                if (value != Integer.MAX_VALUE && value + 1 < result) {
                    result = value + 1;
                }
            }
        }

        return result;
    }
}
