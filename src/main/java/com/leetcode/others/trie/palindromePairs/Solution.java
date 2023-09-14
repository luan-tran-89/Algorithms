package com.leetcode.others.trie.palindromePairs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 * 336. Palindrome Pairs
 *
 * You are given a 0-indexed array of unique strings words.
 * A palindrome pair is a pair of integers (i, j) such that:
 * 0 <= i, j < words.length,
 * i != j, and
 * words[i] + words[j] (the concatenation of the two strings) is a palindrome
 * Return an array of all the palindrome pairs of words.
 *
 * You must write an algorithm with O(sum of words[i].length) runtime complexity.
 *
 * Example 1:
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
 *
 * Example 2:
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 *
 * Example 3:
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["a","a"]
 *
 * Constraints:
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] consists of lowercase English letters.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] words = {"abcd","dcba","lls","s","sssll"};
        System.out.println(s.palindromePairs(words));

        System.out.println(s.palindromePairs(new String[]{"bat","tab","cat"}));
        System.out.println(s.palindromePairs(new String[]{"a",""}));
        System.out.println(s.palindromePairs(new String[]{"a","b","c","ab","ac","aa"}));
    }

    List<List<Integer>> result;

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            insert(root, words[i], i);
        }

        result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i);
        }

        return result;
    }

    private boolean isPalindrome(String str, int i, int len) {
        while (i < len) {
            if (str.charAt(i) != str.charAt(len)) {
                return false;
            }
            i++;
            len--;
        }
        return true;
    }


    private void insert(TrieNode root, String key, int id) {
        TrieNode node = root;

        for (int level = key.length() - 1; level >= 0; level--) {
            int i = key.charAt(level) - 'a';
            if (node.nodes[i] == null) {
                node.nodes[i] = new TrieNode();
            }
            if (isPalindrome(key, 0, level)) {
                node.pos.add(id);
            }
            node = node.nodes[i];
        }
        node.id = id;
        node.pos.add(id);
        node.isEnd = true;
    }

    private void search(TrieNode root, String key, int id) {
        TrieNode node = root;

        for (int level = 0; level < key.length(); level++) {
            int i = key.charAt(level) - 'a';

            if (node.id > 0 &&
                    node.id != id &&
                    isPalindrome(key, level, key.length() - 1)
            ) {
                List<Integer> list = new ArrayList<>();
                list.add(id);
                list.add(node.id);
                if (!result.contains(list)) {
                    result.add(list);
                }
            }

            if (node.nodes[i] == null) {
                return;
            }
            node = node.nodes[i];
        }

        for (int i : node.pos) {
            if (i == id) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            list.add(id);
            list.add(i);
            if (!result.contains(list)) {
                result.add(list);
            }
        }
    }

    static class TrieNode  {
        TrieNode[] nodes;
        List<Integer> pos;
        int id;
        boolean isEnd;

        public TrieNode() {
            nodes = new TrieNode[26];
            pos = new ArrayList<>();
            isEnd = false;
        }
    }
}
