package com.leetcode.recursion.wordSearch;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(s.exist(board, "ABCCED"));
        System.out.println(s.exist(board, "SEE"));
        System.out.println(s.exist(board, "ABCB"));

        char[][] board1 = {
                {'a','b'},
                {'c','d'},
        };
        System.out.println(s.exist(board1, "abcd"));

        char[][] board2 = {
                {'a','a', 'a', 'a'},
                {'a','a', 'a', 'a'},
                {'a','a', 'a', 'a'}
        };
        System.out.println(s.exist(board1, "aaaaaaaaaaaaa"));

        char[][] board3 = {
                {'a','a','b','a','a','b'},
                {'a','a','b','b','b','a'},
                {'a','a','a','a','b','a'},
                {'b','a','b','b','a','b'},
                {'a','b','b','a','b','a'},
                {'b','a','a','a','a','b'}
        };
        System.out.println(s.exist(board3, "bbbaabbbbbab"));

        char[][] board4 = {
                {'a','b'},
                {'c','d'}
        };
        System.out.println(s.exist(board4, "acdb"));
    }

    int ROW;
    int COL;
//    int[] rows = {-1,-1,-1,0,0,1,1,1};
//    int[] cols = {-1,0,1,-1,1,-1,0,1};
    int[] rows = {-1,0,0,1};
    int[] cols = {0,-1,1,0};

    boolean result = false;

    public boolean exist(char[][] board, String word) {
        result = false;
        ROW = board.length;
        COL = board[0].length;
        char[] words = word.toCharArray();

        if (words.length <= ROW * COL) {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (board[i][j] == words[0]) {
                        boolean[][] visited = new boolean[ROW][COL];
                        this.helper(board, words, i, j, -1, -1, 0, words.length - 1, visited);
                    }
                }
            }
        }

        return result;
    }

    private void helper(char[][] board, char[] words, int row, int col, int prevRow, int prevCol,
                        int index, int n, boolean[][] visited
    ) {
        if (index > n || board[row][col] != words[index]) {
            return;
        }

        if (index == n) {
            result = true;
            return;
        }

        for (int i = 0; i < rows.length; i++) {
            int rowIndex = row + rows[i];
            int colIndex = col + cols[i];
            if (this.isValid(rowIndex, colIndex, prevRow, prevCol) && visited[rowIndex][colIndex] == false) {
                visited[rowIndex][colIndex] = true;
                this.helper(board, words, rowIndex, colIndex, row, col, index + 1, n, visited);
                visited[rowIndex][colIndex] = false;
            }
        }
    }

    private boolean isValid(int row, int col, int prevRow, int prevCol) {
        return row >= 0 && row < ROW &&
                col >= 0 && col < COL &&
                !(row == prevRow && col == prevCol);
    }
}
