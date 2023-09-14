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
public class Calculator {

    private List<Character> operators = List.of('+', '-', '*', '/');

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // 10/3- 75/3 = 10/3 - 25 = 21.6666667
        System.out.println(calculator.calculate("((4(5/6)-(4 + 71)/3))"));
    }

    public double calculate(String expression) {
        Stack<Double> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int length = expression.length();

        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < length && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    num.append(c);
                    i++;
                }
                i--;
                numberStack.push(Double.parseDouble(num.toString()));
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (operatorStack.peek() != '(') {
                    evaluateOperation(numberStack, operatorStack);
                }
                operatorStack.pop(); // Pop '(' from the operator stack
            } else if (operators.contains(c)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
                    evaluateOperation(numberStack, operatorStack);
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            evaluateOperation(numberStack, operatorStack);
        }

        return numberStack.pop();
    }

    private static void evaluateOperation(Stack<Double> numberStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = numberStack.pop();
        double operand1 = numberStack.pop();
        double result = performOperation(operator, operand1, operand2);
        numberStack.push(result);
    }

    private static double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        return 0; // Invalid operator
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        }
        return 0;
    }

    public int calculate1(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {

        }

        return 0;
    }

    public int calculate1(Character operator, int num1, int num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Cannot divide to 0 ");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
