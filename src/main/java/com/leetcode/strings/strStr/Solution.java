package com.leetcode.strings.strStr;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 28. Find the Index of the First Occurrence in a String
 *
 * Given two strings needle and haystack,
 * return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 * Constraints:
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.strStr("sadbutsad", "sad"));
        System.out.println(s.strStr("leetcode", "leeto"));
    }


    public int strStr(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        char[] chars1 = needle.toCharArray();

        if (chars.length >= chars1.length) {
            for (int i = 0; i < chars.length; i++) {
                int j = i;
                int k = 0;
                boolean found = true;
                for (; j < chars.length && k < chars1.length; j++, k++) {
                    if (chars[j] != chars1[k]) {
                        found = false;
                        break;
                    }
                }

                if (found && k == chars1.length) {
                    return i;
                }
            }
        }

        return -1;
    }
}
