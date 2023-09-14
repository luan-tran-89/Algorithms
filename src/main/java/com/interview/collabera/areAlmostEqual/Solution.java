package com.interview.collabera.areAlmostEqual;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 * 1790. Check if One String Swap Can Make Strings Equal
 * You are given two strings s1 and s2 of equal length.
 * A string swap is an operation where you choose two indices
 * in a string (not necessarily different) and swap the characters at these indices.
 *
 * Return true if it is possible to make both strings equal
 * by performing at most one string swap on exactly one of the strings.
 * Otherwise, return false.
 *
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 *
 * Example 2:
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 *
 * Example 3:
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 *
 * Constraints:
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 and s2 consist of only lowercase English letters.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.areAlmostEqual("bank", "kanb"));
//        System.out.println(s.areAlmostEqual("attack", "defend"));
//        System.out.println(s.areAlmostEqual("kelb", "kelb"));
//        System.out.println(s.areAlmostEqual("abcd", "dcba"));

        System.out.println(s.areAlmostEqual("bf", "dd"));
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int swap1 = -1;
        int swap2 = -1;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                int val1 = c1 - 'a';
                int val2 = c2 - 'a';
                if (swap1 == -1 && swap2 == -1) {
                    swap1 = val1;
                    swap2 = val2;
                } else {
                    swap1 -= val2;
                    swap2 -= val1;
                }
            }
        }

        return swap1 == 0 && swap2 == 0;
    }

    public boolean areAlmostEqual1(String s1, String s2) {
        int[] count = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a'] += 1;
        }

        for (char c : s2.toCharArray()) {
            count[c - 'a'] += 1;
        }

        for (int c : count) {
            if (c % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
