package com.interview.unitedAirline.secondMinMax;

import java.util.Arrays;

/**
 * Implement a function in Swift that finds the second smallest and second largest elements in an
 * array of integers.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        // 2, 8
        System.out.println(Arrays.toString(s.getSecondMinMax(new int[]{5,8,10,2,7,1})));
    }

    public int[] getSecondMinMax(int[] arr) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i < firstMin) {
                secondMin = firstMin;
                firstMin = i;
            }

            if (i > firstMax) {
                secondMax = firstMax;
                firstMax = i;
            }

        }

        return new int[]{secondMin, secondMax};
    }

}
