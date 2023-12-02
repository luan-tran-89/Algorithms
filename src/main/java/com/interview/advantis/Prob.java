package com.interview.advantis;

/**
 * Given a rectangular matrix of English lowercase letters board and a string word,
 * your task is to find the number of occurrences of word
 * in the rows, columns and diagonals of board
 *
 * Example:
 *  For:
 *      board = [['s', 'o', 's', 'o'],
 *               ['s', 'o', 'o', 's'],
 *               ['s', 's', 's', 's']]
 *  and word = "sos", the output should be solution (board, word) = 3.
 *  There are 2 occurrences of word starting from board[0][0], and one starting from board[0][2]
 *  No other occurrences of word were counted,so the answer is 3.
 *
 *  For:
 *      board = [['a', 'a'],
 *              ['a', 'a']]
 *  and word = "aa", the output should be solution (board, word) = 5.
 *  There are 2 horizontal, 2, vertical, and 1 diagonal occurrence of word, for a total of 5
 *
 * @author gasieugru
 */
public class Prob {

    public static void main(String[] args) {
        char[][] board = {
                {'s', 'o', 's', 'o'},
                {'s', 'o', 'o', 's'},
                {'s', 's', 's', 's'}
        };
        System.out.println(solution(board, "sos"));

        char[][] board1 = {
                {'a', 'a'},
                {'a', 'a'}
        };
        System.out.println(solution(board1, "aa"));
    }

    static int solution(char[][] board, String word) {
        int count = 0;
        int rowCount = board.length;
        int colCount = board[0].length;
        int length = word.length();

        // Check horizontally (→)
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j <= colCount - length; j++) {
                if (checkWord(board, i, j, 0, 1, word)) {
                    count++;
                }
            }
        }

        // Check vertically (↓)
        for (int i = 0; i <= rowCount - length; i++) {
            for (int j = 0; j < colCount; j++) {
                if (checkWord(board, i, j, 1, 0, word)) {
                    count++;
                }
            }
        }

        // Check diagonally (↘)
        for (int i = 0; i <= rowCount - length; i++) {
            for (int j = 0; j <= colCount - length; j++) {
                if (checkWord(board, i, j, 1, 1, word)) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean checkWord(char[][] board, int startRow, int startCol, int rowDir, int colDir, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (board[startRow + i * rowDir][startCol + i * colDir] != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
