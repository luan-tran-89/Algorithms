package com.leetcode.others.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True


        Map<String, Integer> map = new HashMap<>();
        int sum = map.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(""))
                .mapToInt(entry -> entry.getValue()).sum();
    }

}
