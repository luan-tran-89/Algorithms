package com.interview.flexton.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function
 * to generate all combinations of well-formed parentheses.
 *
 * For com.example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @author gasieugru
 */
public class Parentheses {

    public static void main(String[] args) {
        Parentheses solution = new Parentheses();
        System.out.println(solution.generateParenthesis(3));
//        System.out.println(solution.generateParenthesis(5));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
//        generateParenthesis(result, "", 0, 0, n);
        this.generate(result, n, "", 0, 0);
        return result;
    }

    private void generate(List<String> result, int n, String value, int open, int close) {
        if (n*2 == value.length()) {
            result.add(value);
            return;
        }

        if (open < n) {
            this.generate(result, n,value + "(", open + 1, close);
        }

        if (close < open) {
            this.generate(result, n, value + ")", open, close + 1);
        }
    }

    private void generateParenthesis(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generateParenthesis(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            generateParenthesis(result, current + ")", open, close + 1, max);
        }
    }
}
