package com.leetcode.others.longestValidParentheses;

import com.leetcode.example.utils.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 *
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 * Input: s = ""
 * Output: 0
 *
 * Example 4:
 * Input: s = "()(()"
 * Output: 22
 *
 * Constraints:
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses(")()())"));
        System.out.println(s.longestValidParentheses(""));
        System.out.println(s.longestValidParentheses("()(()"));
        System.out.println(s.longestValidParentheses("()()"));
        // 6
        System.out.println(s.longestValidParentheses("(()())"));
    }

    public int longestValidParentheses(String s) {
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        int count = 0;
        int res = 0;
        int dp[] = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.isEmpty() && stack.peek().getKey() == '(') {
                Pair<Character, Integer> value = stack.pop();
                dp[value.getValue()] = 1;
                dp[i] = 1;
            } else {
                stack.add(new Pair<>(c, i));
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            res = Math.max(res, count);
        }

        return res;
    }


    public int longestValidParentheses1(String s) {
        int count = 0;
        int dp[] = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ')') {
                int prev = s.charAt(i - 1);

                if (prev == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 1;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 1 ? dp[i - dp[i-1] - 2] : 0) + 1;
                }
                count = Math.max(count, dp[i]);
            }
        }

        return count * 2;
    }
}
