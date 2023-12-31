package com.leetcode.example.solveSudoku;


public class Solution {
    private int count = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            };
        solution.solveSudoku(board);
        System.out.println(board);
        System.out.println(solution.count);
    }
    public void solveSudoku(char[][] board) {
        this.solve(board);
    }



    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (this.isValid(board, i, j, c)) {
                            count++;
                            board[i][j] = c;
                            if (this.solve(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c || board[3*(row/3)+i/3][3*(col/3)+i%3] == c) {
                return false;
            }
        }
        return true;
    }
}
