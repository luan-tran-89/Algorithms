package com.leetcode.strings.reverseString;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-string/
 * 344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Input: s = ['h','e','l','l','o']
 * Output: ['o','l','l','e','h']
 *
 * Example 2:
 * Input: s = ['H','a','n','n','a','h']
 * Output: ['h','a','n','n','a','H']
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[] s1 = {'h','e','l','l','o'};
        s.reverseString(s1);
        System.out.println(Arrays.toString(s1));

        char[] s2 = {'H','a','n','n','a','h'};
        s.reverseString(s2);
        System.out.println(Arrays.toString(s2));
    }

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while(i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
