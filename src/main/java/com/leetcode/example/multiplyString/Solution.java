package com.leetcode.example.multiplyString;

/**
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.multiply("123", "456"));

        System.out.println(solution.multiply("123", "45"));
    }

    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] pos = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum/10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int p : pos) {
            if (!(result.length() == 0 && p ==0)) {
                result.append(p);
            }
        }

        return result.toString();
    }
}
