package com.leetcode.example.firstOccurrenceString;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("sadbutsad", "sad"));
        System.out.println(solution.strStr("leetcode", "leeto"));
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
