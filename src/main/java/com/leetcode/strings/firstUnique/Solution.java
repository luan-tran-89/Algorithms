package com.leetcode.strings.firstUnique;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.firstUniqChar("leetcode"));
        System.out.println(s.firstUniqChar("loveleetcode"));
        System.out.println(s.firstUniqChar("aabb"));


    }

    public int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && s.lastIndexOf(c) == index) {
                res = Math.min(res, index);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, Integer.MAX_VALUE);
            } else {
                map.put(c, i);
            }
        }

        return map.values().stream()
                .filter(v -> v != Integer.MAX_VALUE)
                .findFirst()
                .orElse(-1);
    }
}
