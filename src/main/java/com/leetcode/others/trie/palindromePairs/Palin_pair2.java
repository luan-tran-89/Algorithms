package com.leetcode.others.trie.palindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gasieugru
 */
public class Palin_pair2 {
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    // Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        List<Integer> pos; // To store palindromic
        // positions in str
        int id;

        // isLeaf is true if the node represents
        // end of a word
        boolean isLeaf;

        // constructor
        public TrieNode() {
            isLeaf = false;
            pos = new ArrayList<>();
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    // Utility function to check if a string is a
    // palindrome
    static boolean isPalindrome(String str, int i, int len) {
        // compare each character from starting
        // with its corresponding character from last
        while (i < len) {
            if (str.charAt(i) != str.charAt(len))
                return false;

            i++;
            len--;
        }
        return true;
    }

    // If not present, inserts reverse of key into Trie. If
    // the key is prefix of a Trie node, just mark leaf node
    static void insert(TrieNode root, String key, int id) {
        TrieNode pCrawl = root;

        // Start traversing word from the last
        for (int level = key.length() - 1; level >= 0; level--) {
            // If it is not available in Trie, then
            // store it
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            // If current word is palindrome till this
            // level, store index of current word.
            if (isPalindrome(key, 0, level))
                (pCrawl.pos).add(id);

            pCrawl = pCrawl.children[index];
        }
        pCrawl.id = id;
        pCrawl.pos.add(id);

        // mark last node as leaf
        pCrawl.isLeaf = true;
    }

    // list to store result
    static List<List<Integer>> result;

    // Returns true if key presents in Trie, else false
    static void search(TrieNode root, String key, int id) {
        TrieNode pCrawl = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';

            // If it is present also check upto which index
            // it is palindrome
            if (pCrawl.id >= 0 && pCrawl.id != id
                    && isPalindrome(key, level, key.length() - 1)) {
                List<Integer> l = new ArrayList<>();
                l.add(id);
                l.add(pCrawl.id);
                result.add(l);
            }

            // If not present then return
            if (pCrawl.children[index] == null)
                return;

            pCrawl = pCrawl.children[index];
        }

        for (int i : pCrawl.pos) {
            if (i == id)
                continue;
            List<Integer> l = new ArrayList<>();
            l.add(id);
            l.add(i);
            result.add(l);
        }
    }

    // Function to check if a palindrome pair exists
    static boolean checkPalindromePair(List<String> vect) {

        // Construct trie
        TrieNode root = new TrieNode();
        for (int i = 0; i < vect.size(); i++)
            insert(root, vect.get(i), i);

        // Search for different keys
        result = new ArrayList<>();
        for (int i = 0; i < vect.size(); i++) {
            search(root, vect.get(i), i);
        }
        if (result.size() > 0)
            return true;

        return false;
    }

    // Driver code
    public static void main(String args[]) {
        List<String> vect = Arrays.asList("abcd","dcba","lls","s","sssll");

        if (checkPalindromePair(vect) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println(result);
    }
}
