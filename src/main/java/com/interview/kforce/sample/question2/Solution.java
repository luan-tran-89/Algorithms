package com.interview.kforce.sample.question2;

import java.util.*;
import java.util.stream.Stream;

/**
 * Note: In this task we define the vowels as
 * 'a', 'e', 'i', 'o', 'u', 'y'
 * All other letters are consonants.
 *
 * Example
 * README
 * • For pattern = "010" and source = "amazing", the output should be solution (pattern, source) = 2
 *
 * Expand to see the com.example video.
 *  ama
 *  azi
 *
 * @author gasieugru
 */
public class Solution {

    private Map<Character, Character> vowels = new HashMap<>();

    {
        vowels.put('a', '0');
        vowels.put('e', '0');
        vowels.put('i', '0');
        vowels.put('o', '0');
        vowels.put('u', '0');
        vowels.put('y', '0');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("010", "amazing"));


        int[] a = {};
    }

    int solution(String pattern, String source) {
        int match = 0;
        int patternLength = pattern.length();

        List<String> list = new ArrayList<>();
        for (int i = 0; i <= source.length() - patternLength; i++) {
            list.add(source.substring(i, i + pattern.length()));
        }


        for (String s : list) {
            boolean isMatched = true;
            for (int j = 0; j < patternLength; j++) {
                char vowel = vowels.containsKey(s.charAt(j)) ? vowels.get(s.charAt(j)) : '1';
                if (pattern.charAt(j) != vowel) {
                    isMatched = false;
                    break;
                }
            }
            if (isMatched) {
                match++;
            }
        }

        return match;
    }
}
