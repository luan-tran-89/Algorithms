package com.interview.flexton.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 *
 * @author gasieugru
 */
public class PalindromicString {

    public static void main(String[] args) {
        PalindromicString solution = new PalindromicString();
        System.out.println(solution.getPalindromeString("abc"));
        System.out.println(solution.getPalindromeString("aaa"));
    }

    public int getPalindromeString(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(i)));
            result.add(sb.toString());

            for (int j = i+1; j < s.length(); j++) {
                if (i != j) {
                    sb.append(s.charAt(j));
                }
                if (this.isPalindrome(sb.toString())) {
                    result.add(sb.toString());
                }
            }
        }
        Collections.sort(result);
        return result.size();
    }


    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left)!= s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

//        return (new StringBuilder(s)).reverse().toString().equals(s);
        return true;
    }
}
