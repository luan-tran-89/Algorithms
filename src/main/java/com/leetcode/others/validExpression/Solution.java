package com.leetcode.others.validExpression;

import java.util.Stack;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isValidMathExpression("5+(4*X)+(2/[1+y])"));  // Valid
//        System.out.println(isValidMathExpression("5+4*X)+[(2/1+y])"));  // Invalid
//        System.out.println(isValidMathExpression("5+4*X+(2/[1+y])"));  // Invalid

    }

    public static boolean isValidMathExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '*' || c == '/') {
                // Multiplication and division have higher precedence than addition and subtraction,
                // so we need to pop all of the operators on the stack before pushing the new operator.
                while (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
                    stack.pop();
                }
                stack.push(c);
            } else if (c == '+' || c == '-') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.push(c);
                }
            } else if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                continue;
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']');
    }

}
