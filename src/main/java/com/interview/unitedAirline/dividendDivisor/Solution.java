package com.interview.unitedAirline.dividendDivisor;

import java.util.Arrays;

/**
 * Write a recursive function in Swift to calculate the division between 2 positive integers.
 * The function will take two params, dividend & divisor, and must return a tuple (quotient, remainder)
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.divided(10, 3)));

        System.out.println(Arrays.toString(s.divided(1, 3)));
    }

    public int[] divided(int dividend, int divisor) {
        if (dividend < divisor) {
            return new int[]{0, dividend};
        }

        int[] res =  this.divided(dividend - divisor, divisor);

        return new int[]{res[0] + 1, res[1]};
    }

}
