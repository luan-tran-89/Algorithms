package com.interview.flexton.test3;

import java.util.Map;
import java.util.Stack;

/**
 * Write a function to check if a string which contains "()" only is valid.
 *
 * for com.example "()(()(()))"
 *
 * @author gasieugru
 */
public class ValidParentheses {
    private Map<Character, Character> map = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()(()(()))"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().equals(map.get(c))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
