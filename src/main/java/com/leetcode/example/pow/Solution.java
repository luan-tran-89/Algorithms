package com.leetcode.example.pow;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * -104 <= xn <= 104
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.myPow(2.00000, 10));
        System.out.println(solution.myPow(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);

        if (n == 0) {
            return 1;
        }

        if (x == 1 || x == -1) {
            return x;
        }

        if (n == Integer.MIN_VALUE) {
            return 0;
        }

        double pow = x;
        for (int i = 1; i < n; i++) {
            pow *= x;
        }

        return sign == -1 ? 1/pow : pow;
    }
}
