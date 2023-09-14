package com.leetcode.others.trie.findWords;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gasieugru
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(s.findWords(board, words));

        char[][] board1 = {
                {'a', 'b'},
                {'c', 'd'},
        };
        String[] words1 = {"abcb"};
        System.out.println(s.findWords(board1, words1));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = TrieNode.buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, res, i, j);
            }
        }

        return res;
    }

    private void dfs(char[][] board, TrieNode node, List<String> res, int i, int j) {
        char c = board[i][j];
        if (c == '.' || node.nodes[c - 'a'] == null) {
            return;
        }

        node = node.nodes[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // Ignore duplicate
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

    static class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        String word;

        static TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();

            for (String word:words) {
                TrieNode node = root;

                for (char c : word.toCharArray()) {
                    int i = c - 'a';
                    if (node.nodes[i] == null) {
                        node.nodes[i] = new TrieNode();
                    }
                    node = node.nodes[i];
                }

                node.word = word;
            }
            return root;
        }

    }
}
