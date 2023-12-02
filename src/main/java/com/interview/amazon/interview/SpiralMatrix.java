package com.interview.amazon.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 *  Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *  Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *  Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 *  Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 *  m == matrix.length
 *  n == matrix[i].length
 *  1 <= m, n <= 10
 *  -100 <= matrix[i][j] <= 100
 *
 * @author gasieugru
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        /*
        *   x1      x2
        *   1   2   3   y1
        *   4   5   6
        *   7   8   9   y2
        */
        System.out.println(spiralOrder(matrix));

        int[][] matrix1 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        /*
         *   x1          x2
         *   1   2   3   4      y1
         *   5   6   7   8
         *   9  10   11  12     y2
         */
        System.out.println(spiralOrder(matrix1));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        topRight(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1, res);
        return res;
    }

    public static void topRight(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> list) {
        for (int i = x1; i <= x2; i++) {
            list.add(matrix[y1][i]);
        }

        for (int i = y1 + 1; i <= y2; i++) {
            list.add(matrix[i][x2]);
        }

        if (x2 - x1 > 0 && y2 - y1 > 0) {
            x2--;
            y1++;
            bottomUp(matrix, x1, y1, x2, y2, list);
        }
    }

    public static void bottomUp(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> list) {
        for (int i = x2; i >= x1; i--) {
            list.add(matrix[y2][i]);
        }

        for (int i = y2 - 1; i >= y1; i--) {
            list.add(matrix[i][x1]);
        }

        if (x2 - x1 > 0 && y2 - y1 > 0) {
            x1++;
            y2--;
            topRight(matrix, x1, y1, x2, y2, list);
        }
    }

}
