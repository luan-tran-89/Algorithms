package com.leetcode.recursion.pascalTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 *
 * Constraints:
 * 0 <= rowIndex <= 33
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getRow(3));
        System.out.println(solution.getRow(0));
        System.out.println(solution.getRow(1));
    }

    List<List<Integer>> rows = null;

    public List<Integer> getRow(int rowIndex) {
        if (rows == null) {
            rows = this.generatePascalsTriangle();
        }

        return rows.get(rowIndex);
    }

    private List<List<Integer>> generatePascalsTriangle() {
        List<List<Integer>> rows = new ArrayList<>();

        for (int i = 0; i <= 33; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> prevRow = rows.get(i - 1);
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            rows.add(row);
        }

        return rows;
    }
}
