package com.interview.pi.maxPalindromes;

/**
 * 2472. Maximum Number of Non-overlapping Palindrome Substrings
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/description/
 *
 * You are given a string s and a positive integer k.
 *
 * Select a set of non-overlapping substrings from the string s that satisfy the following conditions:
 *
 * The length of each substring is at least k.
 * Each substring is a palindrome.
 * Return the maximum number of substrings in an optimal selection.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "abaccdbbd", k = 3
 * Output: 2
 * Explanation: We can select the substrings underlined in s = "abaccdbbd".
 * Both "aba" and "dbbd" are palindromes and have a length of at least k = 3.
 * It can be shown that we cannot find a selection with more than two valid substrings.
 *
 * Example 2:
 * Input: s = "adbcda", k = 2
 * Output: 0
 * Explanation: There is no palindrome substring of length at least 2 in the string.
 *
 * Constraints:
 * 1 <= k <= s.length <= 2000
 * s consists of lowercase English letters.
 *
 * @author gasieugru
 */
public class MaxPalindromes {
    private int count = 0;
    private int start = 0;

    public static void main(String[] args) {
        MaxPalindromes solution = new MaxPalindromes();

        System.out.println(solution.maxPalindromes("aababaabce", 3));
    }


    public int maxPalindromes(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            this.palindrome(s, k, i, i);
            this.palindrome(s, k, i, i + 1);
        }
        return count;
    }

    private void palindrome(String s, int k, int i, int j) {
        while(i >= start && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }

            int lengthOfPalindrome = j - i + 1;
            if (lengthOfPalindrome >= k) {
                count++;
                start = j + 1;
                break;
           }
            i--;
            j++;
        }
    }
}
