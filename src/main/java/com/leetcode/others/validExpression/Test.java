package com.leetcode.others.validExpression;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

/**
 * @author gasieugru
 */
public class Test {
    public static boolean isValidMathExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else if (isCloseBracket(ch)) {
                char expectedOpenBracket = getMatchingOpenBracket(ch);
                if (stack.isEmpty() || stack.pop() != expectedOpenBracket) {
                    return false; // Mismatched closing parenthesis/bracket
                }
            } else if (isOperator(ch)) {
                if (stack.isEmpty() || isOpenBracket(stack.peek())) {
                    return false; // Operator at the beginning or after an open parenthesis/bracket
                }
                stack.push(ch);
            } else if (Character.isLetterOrDigit(ch) || ch == ' ') {
                // Valid character (letters, digits, or spaces)
            } else {
                return false; // Invalid character
            }
        }

        // Ensure all parentheses and brackets are matched
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[';
    }

    private static boolean isCloseBracket(char ch) {
        return ch == ')' || ch == ']';
    }

    private static boolean isOperator(char ch) {
        return "+-*/".indexOf(ch) != -1;
    }

    private static char getMatchingOpenBracket(char closeBracket) {
        return (closeBracket == ')') ? '(' : '[';
    }

    public static void main(String[] args) throws ScriptException {
        System.out.println(isValidMathExpression("5+(4*×)+(2/[1+y])"));  // Valid
//        System.out.println(isValidMathExpression("5+4*x)+[(2/1+y])"));  // Invalid
//        System.out.println(isValidMathExpression("5+4*×+(2/[1+y])"));  // Invalid

//        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
//        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("js");
        String expression = "5+(4*×)+(2/[1+y])";
//        Integer result = (Integer) scriptEngine.eval(expression);

        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        Object result1 = engine.eval(expression);

    }
}
