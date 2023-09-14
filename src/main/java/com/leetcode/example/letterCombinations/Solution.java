package com.leetcode.example.letterCombinations;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    private Map<Character, String> letters = new HashMap<>();

    {
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits.trim())) {
            return Collections.EMPTY_LIST;
        }
        if (digits.length() == 1) {
            return letters.get(digits.charAt(0))
                    .chars()
                    .mapToObj(c -> (char)c)
                    .map(c -> String.valueOf(c))
                    .collect(Collectors.toList());
        }
        List<String> result = new ArrayList<>();
        List<String> list = this.letterCombinations(digits.substring(1, digits.length()));
        String first = letters.get(digits.charAt(0));

        for (int i = 0; i< first.length(); i++) {
            for (int j = 0; j < list.size(); j++) {
                result.add("" + first.charAt(i) + list.get(j));
            }
        }

        return result;
    }

}
