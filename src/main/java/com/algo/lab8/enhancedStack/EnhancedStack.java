package com.algo.lab8.enhancedStack;

import java.util.Stack;

/**
 * @author gasieugru
 */
public class EnhancedStack {
    private Stack<Integer> stack;
    private Integer min;

    public EnhancedStack() {
        this.stack = new Stack<>();
    }

    public Integer getMin() {
        if (stack.isEmpty()) {
            return null;
        }
        return this.min;
    }

    public Integer peek() {
        if (stack.isEmpty()) {
            return null;
        }
        Integer value = stack.peek();
        return value < min ? min : value;
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        Integer value = stack.pop();
        Integer top = value;
        if (value < min) {
            top = min;
            min = 2 * min - value;
        }
        return top;
    }

    public void push(Integer value) {
        if (stack.isEmpty()) {
            this.min = value;
            stack.push(value);
        } else if (value < min) {
            stack.push(2 * value - min);
            min = value;
        } else {
            stack.push(value);
        }
    }

    public static void main(String[] args) {
        EnhancedStack enhancedStack = new EnhancedStack();
        enhancedStack.push(1);
        System.out.print(enhancedStack.pop());
        enhancedStack.push(2);
        enhancedStack.push(3);
        enhancedStack.push(4);
        enhancedStack.push(5);
        System.out.print(enhancedStack.pop());
        System.out.print(enhancedStack.pop());
        enhancedStack.push(6);
        System.out.print(enhancedStack.pop());
        System.out.print(enhancedStack.pop());
        System.out.print(enhancedStack.pop());
    }
}
