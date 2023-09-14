package com.leetcode.example.uniquePathsIII;

/**
 * https://leetcode.com/problems/unique-paths-iii/description/
 *
 * 980. Unique Paths III - Hard
 * You are given an m x n integer array grid where grid[i][j] could be:
 *
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 * Example 1:
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 *
 * Example 2:
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 *
 * Example 3:
 * Input: grid = [[0,1],[2,0]]
 * Output: 0
 * Explanation: There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 20
 * 1 <= m * n <= 20
 * -1 <= grid[i][j] <= 2
 * There is exactly one starting cell and one ending cell.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        System.out.println(solution.uniquePathsIII(input));

        int[][] input1 = {{1,0,0,0}, {0,0,0,0}, {0,0,0,2}};
        System.out.println(solution.uniquePathsIII(input1));

        int[][] input2 = {{0,1}, {2,0}};
        System.out.println(solution.uniquePathsIII(input2));
    }

    public int uniquePathsIII(int[][] grid) {
        int zero = 0;
        int x = 0;
        int y = 0;

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    zero++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        return path(grid, x, y, zero);
    }

    private int path(int[][] grid, int x, int y, int zero) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return zero == -1 ? 1 : 0;
        }
        grid[x][y] = -1;
        zero--;

        int total = this.path(grid, x+1, y, zero) +
                this.path(grid, x, y+1, zero) +
                this.path(grid, x-1, y, zero) +
                this.path(grid, x, y-1, zero);

        grid[x][y] = 0;
        zero++;

        return total;
    }
}
