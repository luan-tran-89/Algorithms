package com.leetcode.example.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }


    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));

            if (map.containsKey(c)) {
                j = Math.max(j, map.get(c));
            }

            result = Math.max(result, i - j + 1);
            map.put(c, i + 1);
        }

        return result;
    }
}
