package com.leetcode.strings.reverseInteger;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/editorial/
 * <p>
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers
 * (signed or unsigned).
 * <p>
 * Example 1:
 * Input: x = 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: x = -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: x = 120
 * Output: 21
 * <p>
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(120));
    }

    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int i = x % 10;

            if ((res > Integer.MAX_VALUE / 10) ||
                (res == Integer.MAX_VALUE / 10 && i > 7) ||
                (res < Integer.MIN_VALUE / 10) ||
                (res == Integer.MIN_VALUE / 10 && i < -8)
            ) {
                return 0;
            }

            res = res * 10 + i;
            x /= 10;
        }

        return res;
    }
}
