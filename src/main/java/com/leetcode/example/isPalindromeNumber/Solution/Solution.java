package com.leetcode.example.isPalindromeNumber.Solution;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reverse = 0;
        int tmp = x;

        while (tmp > 0) {
            int digit = tmp%10;
            reverse = reverse * 10 + digit;
            tmp = tmp/10;
        }

        return reverse == x;
    }
}
