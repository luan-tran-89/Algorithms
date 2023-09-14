package com.leetcode.example.isPalindrome;

/**
 * @author gasieugru
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome("Input: s = \"A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            Character start = Character.valueOf(s.charAt(i));
            Character end = Character.valueOf(s.charAt(j));

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
