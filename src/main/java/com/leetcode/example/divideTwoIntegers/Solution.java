package com.leetcode.example.divideTwoIntegers;

/**
 * https://leetcode.com/problems/divide-two-integers/description/
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For com.example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
 *
 *
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = 3.33333.. which is truncated to 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 *
 *
 * Constraints:
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));
        System.out.println(solution.divide(7, -3));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            // throw Exception("Can't divide to 0");
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        if (dividend == 0 || lDividend < lDivisor) {
            return 0;
        }

        long multiple = this.divide(lDividend, lDivisor);
        int result;
        if (multiple > Integer.MAX_VALUE) {
            result = sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            result = (int) (sign * multiple);
        }

        return result;
    }

    public long divide(long dividend, long divisor) {
        if (dividend == 0 || dividend < divisor) {
            return 0;
        }

        long sum = divisor;
        long multiple = 1;

        while ((sum + sum) <= dividend) {
            sum += sum;
            multiple += multiple;
        }

        return multiple + this.divide(dividend - sum, divisor);
    }
}
