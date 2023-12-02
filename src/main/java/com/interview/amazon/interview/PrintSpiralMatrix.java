package com.interview.amazon.interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gasieugru
 */
public class PrintSpiralMatrix {

    public static void main(String[] args) {
        display(getSpiralMatrix(3, 3));

        display(getSpiralMatrix(3, 4));

    }

    public static void display(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    static int count = 0;

    public static int[][] getSpiralMatrix(int row, int col) {
        count = 0;
        int[][] matrix = new int[row][col];
        topRight(matrix, 0, 0, col - 1, row - 1);
        return matrix;
    }

    private static void topRight(int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            matrix[y1][i] = count++;
        }

        for (int i = y1 + 1; i <= y2; i++) {
            matrix[i][x2] = count++;
        }

        if (x2 - x1 > 0 && y2 - y1 > 0) {
            x2--;
            y1++;
            bottomLeft(matrix, x1, y1, x2, y2);
        }
    }

    private static void bottomLeft(int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int i = x2; i >= x1; i--) {
            matrix[y2][i] = count++;
        }

        for (int i = y2 - 1; i >= y1; i--) {
            matrix[i][x1] = count++;
        }

        if (x2 - x1 > 0 && y2 - y1 > 0) {
            x1++;
            y2--;
            topRight(matrix, x1, y1, x2, y2);
        }
    }

}
