package com.interview.walmart.demo.coinChangeII;

/**
 * 518. Coin Change II
 * https://leetcode.com/problems/coin-change-ii/description/
 *
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 * Example 1:
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * Constraints:
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.change(5, new int[]{5,2,1}));
        // [1,0,0,0,0,0]
        // [1,0,0,0,0,1] - 5 - 5
        // [1,0,1,0,0,1] - 2 - 2
        // [1,0,1,0,0,1] - 2 - 3
        // [1,0,1,0,1,1] - 2 - 4
        // [1,0,1,0,1,1] - 2 - 5
        // [1,1,1,0,1,1] - 1 - 1
        // [1,1,2,0,1,1] - 1 - 2
        // [1,1,2,2,1,1] - 1 - 3
        // [1,1,2,2,3,1] - 1 - 4
        // [1,1,2,2,3,4] - 1 - 5

//        System.out.println(s.change(5, new int[]{1,2,5}));
        // [1,0,0,0,0,0]
        // [1,1,0,0,0,0] - 1 - 1
        // [1,1,1,0,0,0] - 1 - 2
        // [1,1,1,1,0,0] - 1 - 3
        // [1,1,1,1,1,0] - 1 - 4
        // [1,1,1,1,1,1] - 1 - 5
        // [1,1,2,1,1,1] - 2 - 2
        // [1,1,2,2,1,1] - 2 - 3
        // [1,1,2,2,3,1] - 2 - 4
        // [1,1,2,2,3,3] - 2 - 5
        // [1,1,2,2,3,4] - 5 - 5

//        System.out.println(s.change(10, new int[]{2, 5, 3, 6}));
        // [1,0,0,0,0,0,0,0,0,0,0]
        // [1,0,1,0,0,0,0,0,0,0,0] - 2 - 2
        // [1,0,1,0,0,0,0,0,0,0,0] - 2 - 3
        // [1,0,1,0,1,0,0,0,0,0,0] - 2 - 4
        // [1,0,1,0,1,0,0,0,0,0,0] - 2 - 5
        // [1,0,1,0,1,0,1,0,0,0,0] - 2 - 6
        // [1,0,1,0,1,0,1,0,0,0,0] - 2 - 7
        // [1,0,1,0,1,0,1,0,1,0,0] - 2 - 8
        // [1,0,1,0,1,0,1,0,1,0,0] - 2 - 9
        // [1,0,1,0,1,0,1,0,1,0,1] - 2 - 10
        // [1,0,1,0,1,1,1,0,1,0,1] - 5 - 5
        // [1,0,1,0,1,1,1,0,1,0,1] - 5 - 6
        // [1,0,1,0,1,1,1,1,1,0,1] - 5 - 7
        // [1,0,1,0,1,1,1,1,1,0,1] - 5 - 8
        // [1,0,1,0,1,1,1,1,1,1,1] - 5 - 9
        // [1,0,1,0,1,1,1,1,1,1,2] - 5 - 10
        // [1,0,1,1,1,1,1,1,1,1,2] - 3 - 3
        // [1,0,1,1,1,1,1,1,1,1,2] - 3 - 4
        // [1,0,1,1,1,2,1,1,1,1,2] - 3 - 5
        // [1,0,1,1,1,2,2,1,1,1,2] - 3 - 6
        // [1,0,1,1,1,2,2,2,1,1,2] - 3 - 7
        // [1,0,1,1,1,2,2,2,3,1,2] - 3 - 8
        // [1,0,1,1,1,2,2,2,3,3,2] - 3 - 9
        // [1,0,1,1,1,2,2,2,3,3,4] - 3 - 10
        // [1,0,1,1,1,2,3,2,3,3,4] - 6 - 6
        // [1,0,1,1,1,2,3,2,3,3,4] - 6 - 7
        // [1,0,1,1,1,2,3,2,4,3,4] - 6 - 8
        // [1,0,1,1,1,2,3,2,4,4,4] - 6 - 9
        // [1,0,1,1,1,2,3,2,4,4,5] - 6 - 10
    }

    /**
     * Time Complexity: O(n * m)
     * Auxiliary Space: O(n)
     *  with n is target amount
     *       m is the number of coins
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }


    /**
     * Time Complexity: O(2^sum)
     * Auxiliary Space: O(amount)
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change1(int amount, int[] coins) {
        return this.change(coins, coins.length, amount);
    }

    private int change(int[] coins, int n, int amount) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }

        if (n <= 0) {
            return 0;
        }

        return this.change(coins, n - 1, amount) + this.change(coins, n, amount - coins[n-1]);
    }

    public int change2(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        int nowsIncludingLastElement;
        int nowsExcludingLastElement;
        int lastCoinValue;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                lastCoinValue = coins[i - 1];
                if (j < lastCoinValue) {
                    nowsIncludingLastElement = 0;
                } else {
                    nowsIncludingLastElement = dp[i][j - lastCoinValue];
                }
                nowsExcludingLastElement = dp[i - 1][j];
                dp[i][j] = nowsIncludingLastElement + nowsExcludingLastElement;
                System.out.println(dp[i][j]);
            }
        }

        return dp[coins.length][amount];
    }
}
