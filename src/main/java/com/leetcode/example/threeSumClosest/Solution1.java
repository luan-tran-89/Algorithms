package com.leetcode.example.threeSumClosest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author gasieugru
 */
public class Solution1 {
    private Map<Character, Character> map = new HashMap<>();

    {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isValid("()[]{}"));
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
