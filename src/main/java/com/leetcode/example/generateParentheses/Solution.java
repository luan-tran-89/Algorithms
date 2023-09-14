package com.leetcode.example.generateParentheses;


import java.util.*;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis1(3));
        // Output: ["((()))","(()())","(())()","()(())","()()()"]
    }

    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        this.generateParenthesis1(result, 0, 0, "", n);
        return result;
    }

    private void generateParenthesis1(List<String> result, int left, int right, String value, int n) {
        if (value.length() == n * 2) {
            result.add(value);
        } else {
            if (left < n) {
                this.generateParenthesis1(result, left + 1, right, String.format("%s(", value), n);
            }

            if (right < left) {
                this.generateParenthesis1(result, left, right + 1, String.format("%s)", value), n);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        this.generateParenthesis(result, 0, 0, "", n);
        return result;
    }

    public void generateParenthesis(List<String> result, int left, int right, String value, int n) {
        if (value.length() == n * 2) {
            result.add(value);
            return;
        }

        if (left < n) {
            this.generateParenthesis(result, left+1, right, String.format("%s(", value), n);
        }

        if (right < left) {
            this.generateParenthesis(result, left, right+1, String.format("%s)", value), n);
        }
    }

}
