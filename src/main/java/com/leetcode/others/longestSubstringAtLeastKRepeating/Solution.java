package com.leetcode.others.longestSubstringAtLeastKRepeating;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 * 395. Longest Substring with At Least K Repeating Characters
 *
 * Given a string s and an integer k, return the length of the longest substring of s such that
 * the frequency of each character in this substring is greater than or equal to k.
 * if no such substring exists, return 0.
 *
 * Example 1:
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 * Example 2:
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^5
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        // 3
//        System.out.println(s.longestSubstring("aaabb", 3));
        // 5
//        System.out.println(s.longestSubstring("ababbc", 2));
        // 0
        System.out.println(s.longestSubstring("ababacb", 3));
    }

    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int[] countMap = new int[26];
        int result = 0;

        int maxUnique = this.countUniqueChar(s);
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            Arrays.fill(countMap, 0);
            int start = 0;
            int end = 0;
            int index = 0;
            int unique = 0;
            int countAtLeastK = 0;

            while(end < chars.length) {
                if (unique <= currUnique) {
                    index = chars[end] - 'a';
                    if (countMap[index] == 0) {
                        unique++;
                    }
                    countMap[index]++;

                    if (countMap[index] == k) {
                        countAtLeastK++;
                    }
                    end++;
                } else {
                    index = chars[start] - 'a';
                    if (countMap[index] == k) {
                        countAtLeastK--;
                    }
                    countMap[index]--;

                    if (countMap[index] == 0) {
                        unique--;
                    }
                    start++;
                }
                if (unique == currUnique && unique == countAtLeastK) {
                    result = Math.max(result, end - start);
                }
            }

        }

        return result;
    }

    private int countUniqueChar(String s) {
        boolean[] map = new boolean[26];
        int maxUnique = 0;

        for (char c : s.toCharArray()) {
            if (!map[c - 'a']) {
                map[c - 'a'] = true;
                maxUnique++;
            }
        }

        return maxUnique;
    }

}
