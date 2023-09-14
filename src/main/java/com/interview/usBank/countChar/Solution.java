package com.interview.usBank.countChar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "    testing testing testing   8888 z ";
        System.out.println(solution.countChar(input));

        int[] chars = solution.countChar1(input);
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i];
            if (c > 0) {
                System.out.println(String.format("%s - %s", Character.toString(i), c ));
                count++;
            }
        }
        System.out.println(count);
        System.out.println(chars['t']);
    }

    public Map<Character, Integer> countChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        return map;
    }

    public int[] countChar1(String str) {
        int[] chars = new int[128];

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                chars[c] += 1;
            }
        }

        return chars;
    }

}
