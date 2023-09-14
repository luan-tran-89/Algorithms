package com.leetcode.example.largestRectangleArea;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 84. Largest Rectangle in Histogram
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 * Example 1:
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 *
 * Example 2:
 * Input: heights = [2,4]
 * Output: 4
 *
 * Constraints:
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] h = {2,1,2};
        int[] h = {2,3,1,5,6,2,3};
//        int[] h = {4,2};
        System.out.println(solution.largestRectangleArea(h));
    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int area = 0;
        int start;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int current = heights[i];
            start = i;

            while(!stack.isEmpty() && stack.peek().getValue() > current) {
                Pair<Integer, Integer> pair = stack.pop();
                int index = pair.getKey();
                int height = pair.getValue();
                area = Math.max(area, height * (i - index));
                start = index;
            }

            stack.push(new Pair(start, current));
        }

        while(!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            int index = pair.getKey();
            int height = pair.getValue();
            area = Math.max(area, height * (length - index));
        }
        return area;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
