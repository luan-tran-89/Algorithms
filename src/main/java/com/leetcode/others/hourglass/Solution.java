package com.leetcode.others.hourglass;

import java.util.Arrays;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

//        s.printHourglass(9);

        int[][] res = s.createHourglassMatrix(7);
        for (int[] arr : res) {
            for (int i : arr) {
                System.out.print(i == 1 ? "*" : " ");
            }
            System.out.println();
        }
    }

    public void printHourglass(int n) {
        if (n < 1 || n % 2 == 0) {
            return;
        }

        for (int i = 1; i <= (n + 1)/2; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            if (i != (n + 1)/2) {
                System.out.println();
            }
        }
        System.out.println();
        for (int i = n/2; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            if (i != (n + 1)/2) {
                System.out.println();
            }
        }
    }

    public int[][] createHourglassMatrix(int n) {
        int[][] matrix = new int[n][n];

        if (n < 1 || n % 2 == 0) {
            return matrix;
        }

        for (int i = 0; i < (n/2); i++) {
            for (int j = i; j < n - i; j++) {
                matrix[i][j] = 1;
            }
        }

        for (int i = (n/2); i >= 0; i--) {
            for (int j = i; j < n - i; j++) {
                matrix[n - i - 1][j] = 1;
            }
        }

        return matrix;
    }

}
