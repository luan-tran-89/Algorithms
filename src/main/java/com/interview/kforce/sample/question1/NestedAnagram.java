package com.interview.kforce.sample.question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two sentences s and t , your task is to check whether they are nested anagrams, i.e.
 * if it's possible to rearrange the words in the sentence and the letters in the words themselves such that the sentences become the same.
 * Note that it's not allowed to swap letters in different words,
 * you can only rearrange the whole words within the sentence and rearrange the letters within a single word.
 *
 * It is guaranteed that the words in both sentences are separated with a single whitespace,
 * and that both sentences don't start and end with a whitespace character.
 *
 * It is also guaranteed that each sentence contains at least one word and no more than 100 words.
 *
 * Example
 *  • For s a "bored cat" and t a "act robed" the output should be solution(s, t) = true
 *      There are two words in s: "bored" and "cat"
 *      The first word's letters can be rearranged to become "robed", and the second word's letters can be rearranged to become "act"
 *      When you...
 *
 *
 * @author gasieugru
 */
public class NestedAnagram {
    private static final String SPACE = " ";

    public static void main(String[] args) {
        NestedAnagram solution = new NestedAnagram();

        System.out.println("'bored cat' & 'act robed' :" + solution.nestedAnagram("bored cat", "act robed"));

        System.out.println("'aa bb' & 'ab ab': " + solution.nestedAnagram("aa bb", "ab ab"));

        System.out.println("'meal for one' & 'for me alone': " + solution.nestedAnagram("meal for one", "for me alone"));
    }

    private static char[] sort(char[] s) {
        Arrays.sort(s);
        return s;
    }

    public static boolean nestedAnagram(String s, String t) {
        if (s.startsWith(SPACE) || t.startsWith(SPACE) || s.endsWith(SPACE) || t.endsWith(SPACE) || s.isEmpty() || t.isEmpty()) {
            return false;
        }
        Map<String, char[]> map = new HashMap<>();
        String[] sLists = s.split(SPACE);
        String[] tLists = t.split(SPACE);

        for (String s1 : sLists) {
            if (!map.containsKey(s1)) {
                map.put(s1, sort(s1.toCharArray()));
            }
        }

        int keySize = map.size();
        int count = 0;
        for (Map.Entry<String, char[]> m : map.entrySet()) {
            for (String t2 : tLists) {
                if (m.getKey().length() == t2.length()) {
                    if (Arrays.equals(m.getValue(), sort(t2.toCharArray()))) {
                        count++;
                    }
                }
            }
        }
        return count == keySize;
    }
}
