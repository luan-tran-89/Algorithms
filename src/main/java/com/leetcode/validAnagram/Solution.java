package com.leetcode.validAnagram;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        List<Character> chars1 = s.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
        List<Character> chars2 = t.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());

        for (int i = 0; i < chars1.size(); i++) {
            if (chars1.get(i) != chars2.get(i)) {
                return false;
            }
        }

        return true;
    }
}
