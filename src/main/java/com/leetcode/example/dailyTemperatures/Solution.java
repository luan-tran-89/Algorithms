package com.leetcode.example.dailyTemperatures;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * 739. Daily Temperatures
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 * Constraints:
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 * @author gasieugru
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(solution.dailyTemperatures(temperatures));
        // [1,1,4,2,1,1,0,0]
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }

        return result;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];

        for (int i = length-1; i >= 0; i--) {

            for (int j = i - 1; j >= 0 && temperatures[i] > temperatures[j]; j--) {
                result[j] = i-j;
            }
        }

        return result;
    }
}
