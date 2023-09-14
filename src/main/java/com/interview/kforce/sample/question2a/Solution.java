package com.interview.kforce.sample.question2a;

import java.util.*;

/**
 * A string is said to be beautiful if each letter in the string appears at
 * most as many times as the previous letter in the alphabet within the string;
 *
 * ie: b occurs no more times than a;
 * c occurs no more times than b:
 * etc.
 * Note that letter a has no previous letter
 *
 * Given a string, check whether it is beautiful.
 *
 * Example
 *  - For inputStrina = "bbbaacdafe" the outout should be isBeautifulString(inputString) = true
 *      This string contains 3 a s, 3 b s, 1 c, 1 d, 1 e, and 1 f (and 0 of every other letter),
 *      so since there aren't any letters that appear more frequently than the previous letter,
 *      this string qualifies as beautiful.
 *
 *  - For inputstring = "aabbb" , the output should be isBeautifulStrina(inputStrina) = false
 *      Since there are more 'b' s than 'a' s. this string is not beautiful.
 *
 *  - For inputString = "bbc" , the output should be isBeautifulString(inputstring)=false
 *      Although there are more 'b' s than 'c' s.
 *      this string is not beautiful because there are no 'a' s, so therefore there are more 'b' s than 'a' s
 *
 *  Input/Output
 *      • [execution time limit] 3 seconds (java)
 *      • [input] string inputString
 *          A string of lowercase English letters.
 *
 *  Resolved by Java
 *      https://www.youtube.com/watch?v=hCO3uTSQcJo
 *  Resolved by JS
 *      https://wachino.github.io/codefights/codefights-arcade/codefights-arcade-intro/43_isBeautifulString/README.html
 *      https://onecompiler.com/javascript/3w9vwctsh
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("bbbaacdafe: " + solution.isBeautifulString("bbbaacdafe"));
        System.out.println("aabbb: " + solution.isBeautifulString("aabbb"));
        System.out.println("bbc: " + solution.isBeautifulString("bbc"));
    }

    boolean isBeautifulString1(String inputString) {
        Map<Character, Integer> charMap = new HashMap<>();

        // count characters of the input string.
        for (char c : inputString.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int first = (int) 'a';
        int last = (int) 'z';
        int current = Integer.MAX_VALUE;

        for (int i = first; i <= last; i++) {
            int count = charMap.getOrDefault((char) i, 0);
            if (count > current) {
                return false;
            }
            current = count;
        }
        return true;
    }

    boolean isBeautifulString(String inputString) {
        int[] chars = new int[26];

        for (char c : inputString.toCharArray()) {
            chars[c - 'a'] += 1;
        }

        for (int i = 1; i < 26; i++) {
            if (chars[i - 1] < chars[i]) {
                return false;
            }
        }

        return true;
    }
}
