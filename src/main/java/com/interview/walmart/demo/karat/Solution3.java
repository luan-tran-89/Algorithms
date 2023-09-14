package com.interview.walmart.demo.karat;

import java.util.ArrayList;
import java.util.List;

/**
 * look like this https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
 *
 * https://dotnetfiddle.net/ymCvsJ
 * After catching your classroom students cheating before,
 * you realize your students are getting craftier and hiding words in 2D grids of letters.
 * The word may start anywhere in the grid, and consecutive letters can be either immediately below
 * or immediately to the right of the previous letter.
 *
 * Given a grid and a word, write a function
 * that returns the location of the word in the grid as a list of coordinates.
 * If there are multiple matches, return any one.
 *
 * grid1 = [
 *       0    1    2    3    4    5
 * 0	['c', 'c', 'x', 't', 'i', 'b'],
 * 1	['c', 'c', 'a', 't', 'n', 'i'],
 * 2	['a', 'c', 'n', 'n', 't', 't'],
 * 3	['t', 'c', 's', 'i', 'p', 't'],
 * 4	['a', 'o', 'o', 'o', 'a', 'a'],
 * 5	['o', 'a', 'a', 'a', 'o', 'o'],
 * 6	['k', 'a', 'i', 'c', 'k', 'i'],
 * ]
 *
 * word1 = "catnip"
 * word2 = "cccc"
 * word3 = "s"
 * word4 = "bit"
 * word5 = "aoi"
 * word6 = "ki"
 * word7 = "aaa"
 * word8 = "ooo"
 *
 * grid2 = [['a']]
 * word9 = "a"
 *
 * find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
 *
 * find_word_location(grid1, word2) =>
 *        [(0, 1), (1, 1), (2, 1), (3, 1)]
 *     OR [(0, 0), (1, 0), (1, 1), (2, 1)]
 *     OR [(0, 0), (0, 1), (1, 1), (2, 1)]
 *     OR [(1, 0), (1, 1), (2, 1), (3, 1)]
 * find_word_location(grid1, word3) => [(3, 2)]
 * find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
 * find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
 * find_word_location(grid1, word6) => [(6, 4), (6, 5)]
 * find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
 * find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
 * find_word_location(grid2, word9) => [(0, 0)]
 *
 * r = number of rows
 * c = number of columns
 * w = length of the word
 *
 * Approach:
 * Use DFS and keep traversing if current character equals word[i]
 * - Get height and width of grid
 * - Get length of word
 * - Create coord list to hold result
 * - Edge case: if h x w < word length, return empty list
 * - Create helper dfs to traverse grid
 *
 * DFS helper: input: Tuple<r,c>, int i, string word, result list
 *             output: bool
 * base cases:
 * 	- if out of bounds, return false
 * 	- if i == length, return true
 * recurse cases:
 *    if grid[r,c] == word[i]
 *      - Add coord to result list
 * 	 if (traverse right dfs(r, c+1, i+1, word, result) || traverse down dfs(r+1, c, i+1, word, result))
 * 	    return true
 *    return false
 *
 * where R and C is side of matrix
 * O(R*C*8*len(str))  => O(R*C)
 * O(R*C*len(str)*Number(str)*len(str)) => O(R*C)
 *
 * O(N * M * L * 8^L)
 * where
 *  N is the number of rows in the board,
 *  M is the number of columns in the board
 *  L is the maximum length of the word in the dictionary
 *
 * @author gasieugru
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        List<String> words = List.of("catnip", "cccc", "s", "bit", "aoi", "ki", "aaa", "ooo");
        char[][] grid = {
            {'c', 'c', 'x', 't', 'i', 'b'},
            {'c', 'c', 'a', 't', 'n', 'i'},
            {'a', 'c', 'n', 'n', 't', 't'},
            {'t', 'c', 's', 'i', 'p', 't'},
            {'a', 'o', 'o', 'o', 'a', 'a'},
            {'o', 'a', 'a', 'a', 'o', 'o'},
            {'k', 'a', 'i', 'c', 'k', 'i'}
        };

        s.findWords(grid, words.get(0));
//        Pair<Integer, Integer> pair = new Pair<>();

        char[][] board1 = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words1 = {"oath", "pea", "eat", "rain"};
        s.findWords(board1, words1[0]);
    }
    private int[][] mover = {
        {1, 0}, {0, 1}, {-1, 0},
        {0, -1}, {1, 1}, {-1, -1},
        {1, -1}, {-1, 1}
    };

    public void findWords(char[][] grid, String word) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    String s = word.substring(1);
                    if (this.helper(grid, i, j, s, visited)) {
                        ans.add(String.format("(%s, %s)", i, j));
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private boolean helper(char[][] grid, int row, int col, String word, boolean[][] visited) {
        if (word.length() == 0) {
            return true;
        }
        visited[row][col] = true;
        boolean sol = false;

        for (int[] move : mover) {
            int currRow = move[0] + row;
            int currCol = move[1] + col;

            if (currRow >= 0 && currRow < grid.length && currCol >= 0 && currCol < grid[0].length) {
                if (grid[currRow][currCol] == word.charAt(0) && !visited[currRow][currCol]) {
                    String s = word.substring(1);
                    sol |= this.helper(grid, currRow, currCol, s, visited);
                }
            }
        }

        visited[row][col] = false;
        return sol;
    }

}
