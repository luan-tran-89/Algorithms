package com.leetcode.example.longestPalindrome;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, return the longest
 * palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int begin = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int evenLength = this.getPalindrome(s, i, i);
            int oddLength = this.getPalindrome(s, i, i+1);
            int length = Math.max(oddLength, evenLength);

            if (length > end - begin) {
                begin = i - (length - 1)/2;
                end = i + length/2;
            }
        }

        return s.substring(begin, end + 1);
    }

    public int getPalindrome(String s, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;

        while(leftIndex >= 0 && rightIndex < s.length() && (s.charAt(leftIndex) == s.charAt(rightIndex))) {
            leftIndex--;
            rightIndex++;
        }

        return rightIndex - leftIndex - 1;
    }
}
