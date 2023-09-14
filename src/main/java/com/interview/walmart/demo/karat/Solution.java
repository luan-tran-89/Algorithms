package com.interview.walmart.demo.karat;

import com.leetcode.example.utils.Pair;

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
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
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

//        s.findWords(grid, words.get(0));

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

//        s.findWords(board, "SEE");

        char[][] board3 = {
                {'a','a','b','a','a','b'},
                {'a','a','b','b','b','a'},
                {'a','a','a','a','b','a'},
                {'b','a','b','b','a','b'},
                {'a','b','b','a','b','a'},
                {'b','a','a','a','a','b'}
        };

//        s.findWords(board3, "bbbaabbbbbab");
//        s.findWords(board3, "aab");

        char[][] board4 = {
                {'a','b'},
                {'c','d'}
        };
        s.findWords(board4, "acdb");
    }

    int ROW;
    int COL;
//    int rowNum[] = {-1, -1, -1, 0, 0, 1, 1, 1};
//    int colNum[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    int[] rowNum = {-1,0,0,1};
    int[] colNum = {0,-1,1,0};

    private boolean isValid(int row, int col, int prevRow, int prevCol) {
        // return true if row number and column number
        // is in range
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                !(row == prevRow && col == prevCol);
    }

    public void findWords(char[][] grid, String word) {
        ROW = grid.length;
        COL = grid[0].length;
        char[] chars = word.toCharArray();
//        List<List<Pair<Integer, Integer>>> words = new ArrayList<>();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == chars[0]) {
                    boolean[][] visited = new boolean[ROW][COL];
                    this.helper(grid, i, j , -1, -1, chars, words, new ArrayList<>(), "", 0, chars.length - 1, visited);
                }
            }
        }

//        System.out.println(words);
        words.forEach(s -> System.out.println(s));
    }

    private void helper(char[][] grid, int row, int col,
                        int prevRow, int prevCol, char[] word, List<String> words,
                        List<Pair<Integer, Integer>> path, String path1, int index, int n, boolean[][] visited
    ) {
        if (index > n || grid[row][col] != word[index]) {
            return;
        }

        path1 += String.format(" (%s,%s) ", row, col);
        path.add(new Pair<>(row, col));

        if (index == n) {
            System.out.print(path1 +"\n");
            words.add(path1.trim());
            return;
        }

        for (int k = 0; k < rowNum.length; k++) {
            int rowIndex = row + rowNum[k];
            int colIndex = col + colNum[k];
            if (isValid(rowIndex, colIndex, prevRow, prevCol) && visited[rowIndex][colIndex] == false) {
                visited[rowIndex][colIndex] = true;
                helper(grid, rowIndex, colIndex,
                        row,  col, word, words, path, path1, index + 1, n, visited);
                visited[rowIndex][colIndex] = false;
            }
        }
    }
}
