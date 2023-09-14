package com.leetcode.others.palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome
 * Return all possible palindrome partitioning of s.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.partition("aab"));
        System.out.println(s.partition("a"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        this.helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, String s, int index) {
        int length = s.length();
        if (index == length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < length; i++) {
            if (this.isPalendrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                this.helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalendrome(String s, int begin, int end) {
        while(begin <= end) {
            if (s.charAt(begin++) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

}
