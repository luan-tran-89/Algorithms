package com.leetcode.others.trie.findWords;

import com.leetcode.others.trie.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 * 212. Word Search II
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Example 1:
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 * Example 2:
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(s.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie root = this.buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.dfs(board, root.getRoot(), res, i, j);
            }
        }

        return res;
    }

    private void dfs(char[][] board, Trie.Node node, List<String> res, int i, int j) {
        char c = board[i][j];
        if (c == '.' || node.getNode(c - 'a') == null) {
            return;
        }
        node = node.getNode(c - 'a');

        if (node.getWord() != null) {
            res.add(node.getWord());
        }

        board[i][j] = '.';
        if (i > 0) {
            dfs(board, node, res, i - 1, j);
        }
        if (j > 0) {
            dfs(board, node, res, i, j - 1);
        }
        if (i < board.length - 1) {
            dfs(board, node, res, i + 1, j);
        }
        if (j < board[0].length - 1) {
            dfs(board, node, res, i, j + 1);
        }
        board[i][j] = c;
    }

    private Trie buildTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }

}
