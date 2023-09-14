package com.leetcode.others.setZeroes;

import com.leetcode.example.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * 73. Set Matrix Zeroes
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:2
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        s.setZeroes(matrix);
        Stream.of(matrix).forEach(m -> System.out.println(Arrays.toString(m)));
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();

        // O(n^2)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    pairs.add(new Pair<>(i, j));
                }
            }
        }

        // numbers of zeros * (m + n)
        for (Pair<Integer, Integer> pair : pairs) {
            this.replaceZeros(matrix, pair.getKey(), pair.getValue());
        }

    }

    private void replaceZeros(int[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (i != row) {
                matrix[i][col] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != col) {
                matrix[row][i] = 0;
            }
        }
    }
}
