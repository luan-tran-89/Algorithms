package com.interview.flexton.test3;

import java.util.List;
import java.util.Stack;

/**
 *
 * Write a calculator which can support () + - * / and when * is omitted.
 *
 * for com.example: "((4(5/6)-(4 + 71)/3))"
 *
 * @author gasieugru
 */
public class Calculator1 {

    private static List<Character> operators = List.of('+', '-', '*', '/');

    public static void main(String[] args) {
        Calculator1 calculator = new Calculator1();

        // 10/3- 75/3 = 10/3 - 25 = -21.6666667
        System.out.println(calculator.calculate("((4(5/6)-(4+71)/3))"));
    }

    public static double calculate(String expression) {
        // Remove whitespace from the expression
        expression = expression.replaceAll("\\s+", "");

        // Check if the expression is empty
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Empty expression");
        }

        // Create stacks to store operators and operands
        Stack<Character> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();

        // Iterate through the expression character by character
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is a digit, extract the entire number
            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--;

                // Push the extracted number to the operands stack
                operands.push(Double.parseDouble(sb.toString()));
            } else if (ch == '(') {
                // If the character is an opening parenthesis, push it to the operators stack
                if (i > 0) {
                    char prev = expression.charAt(i - 1);
                    if (Character.isDigit(prev) || prev == ')') {
                        operators.push('*');
                    }
                }
                operators.push(ch);
            } else if (ch == ')') {
                // If the character is a closing parenthesis, calculate the expression within the parentheses
                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluate(operators, operands);
                }

                // Pop the opening parenthesis
                if (!operators.isEmpty()) {
                    operators.pop();
                } else {
                    throw new IllegalArgumentException("Invalid expression: mismatched parentheses");
                }
            } else if (isOperator(ch)) {
                // If the character is an operator (+, -, *, /)
                while (!operators.isEmpty() && operators.peek() != '(' && hasHigherPrecedence(operators.peek(), ch)) {
                    evaluate(operators, operands);
                }

                // Push the current operator to the operators stack
                operators.push(ch);
            } else {
                throw new IllegalArgumentException("Invalid character: " + ch);
            }
        }

        // Evaluate the remaining operators
        while (!operators.isEmpty()) {
            evaluate(operators, operands);
        }

        // The result will be the top element in the operands stack
        if (operands.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return operands.pop();
    }

    private static boolean isOperator(char ch) {
        return operators.contains(ch);
//        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    private static void evaluate(Stack<Character> operators, Stack<Double> operands) {
        if (operands.size() < 2 || operators.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression");
        }

        double operand2 = operands.pop();
        double operand1 = operands.pop();
        char operator = operators.pop();

        double result;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        operands.push(result);
    }
}
