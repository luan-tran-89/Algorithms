package com.interview.sevenEleven.longestCommonSubsequence;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * 1143. Longest Common Subsequence
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 * Constraints:
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        // 3
        System.out.println(s.longestCommonSubsequence("abcde", "aec"));

        // 3
        System.out.println(s.longestCommonSubsequence("abc", "abc"));

        // 0
        System.out.println(s.longestCommonSubsequence("abc", "def"));

        // 5
        System.out.println(s.longestCommonSubsequence("abcba", "abcbcba"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char first = text1.charAt(i - 1);
                char second = text2.charAt(j - 1);
                if (first == second) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            prev = Arrays.copyOf(curr, m + 1);
        }

        return curr[m];
    }

    /**
     * Explanation:
     *      Input: abcde & aec
     *      Output: 2
     *
     *      prev = [0, 0, 0, 0]
     *      curr = [0, 0, 0, 0]
     *      i = 1
     *          j = 1: first = a & second = a
     *              => cur[0,1,0,0]
     *          j = 2: first = a & second = e
     *              => cur[0,1,1,0]
     *          j = 3: first = a & second = c
     *              => cur[0,1,1,1]
     *        => prev = [0,1,1,1]
     *      ...
     *        prev = [0,1,2,2]
     *
     *      => return prev[3] = 2
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        // abcde
        // ace
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                char first = text1.charAt(i - 1);
                char second = text2.charAt(j - 1);
                if (first == second) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
//            int[] temp = curr;
//            prev = temp;
            prev = Arrays.copyOf(curr, m+1);
        }

        return prev[m];
    }
}
