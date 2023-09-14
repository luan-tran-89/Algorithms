package com.interview.sevenEleven;

/**
 * An array A[i] of length 2N consists of only 2 and -2 which is called nice if the sum of all the array elements is equal to 0
 * you are given an integer X denoting the goodness level of the array.
 * The nice arrays called too good if it contains exactly x pairs of p and g (p is not equal to q) such that (Ap + Ap+i + Ap+2 ... + Ag = 0)
 * Find the total number of too good arrays possible.
 * Input Format
 * The input contains two space-separated integers, N and X
 *
 * Input Format
 * The input contains two space- separated integers, N and x
 *
 * Sample Input: 3 3
 * Output Format: The output contains a single integer denoting the total numbrr of too good arrays possible
 * Sample Output: 2
 *
 * Explanation
 * N = 3 and X = 3
 * There are only two sequences that satisfy all the above conditions
 * 1. A = [2,2,2,-2,-2,-2];
 * 2. A = [-2,-2,-2, 2,2,2];
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        // 2
        System.out.println(s.goodarray(3, 3));

        // 2
        System.out.println(s.goodarray(1, 1));

        // 568
        System.out.println(s.goodarray(8, 24));
    }

    public static int goodarray(int N, int X) {
        int[][][] dp = new int[N + 1][2 * N + 1][2 * N * 2 + 1];
        int MOD = 1000000007;

        dp[0][0][N] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = -2 * N * i; k <= 2 * N * i; k++) {
                    dp[i][j][k + N] = dp[i - 1][j][k + N];

                    if (j > 0 && k + 2 * i >= 0 && k - 2 * i <= 0) {
                        dp[i][j][k + N] += dp[i - 1][j - 1][k + 2 * i + N] + dp[i - 1][j - 1][k - 2 * i + N];
                    }

                    dp[i][j][k + N] %= MOD;
                }
            }
        }

        return dp[N][N][X + N];
    }

    public int goodarray2(int N, int X) {
        int[][] dp = new int[N+1][X+1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= X; j++) {
                for (int k = 1; k <= Math.min(2*i, j); k++) {
                    if (k == i+1) {
                        continue;
                    }
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        return dp[N][X];
    }

    public static int goodarray1(int n, int x) {
//        int result = -404;

        int[][] dp = new int[n+1][x+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= 2*i && k <= j; k++) {
                    if (k == i+1) {
                        continue;
                    }
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }

        return dp[n][x];
    }
}
