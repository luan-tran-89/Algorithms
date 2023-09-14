package com.leetcode.recursion.pow;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myPow(2, 10));

        try {
            System.out.println(solution.myPow(2, Integer.MAX_VALUE - 1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double myPow(double x, int n) {
        long longN = n;
        double ans = this.myPow(x, Math.abs(longN));

        return longN < 0 ? 1/ans : ans;
    }

    public double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double tmp = this.myPow(x, n/2);
        tmp *= tmp;

        if (n % 2 == 1) {
            return x * tmp;
        }
        return tmp;
    }
}
