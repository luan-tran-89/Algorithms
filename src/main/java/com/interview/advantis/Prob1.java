package com.interview.advantis;

/**
 * You have a string consisting of zeros, ones and asterisks ( * ). Consider the following operation:
 *  1. Choose any two adjacent positions in the string;
 *  2. If one of them is o, and the other one is 1, remove these two digits from the string.
 * Find the length of the smallest string that can be obtained after applying this operation multiple times.
 *
 * Example
 *  • For s= "01010", the output should be
 *      solution (s) = 1 ;
 *  • For s= "111000", the output should be
 *      solution (s) = 0 ;
 *  • For s= "111*000", the output should be
 *      solution (s) = 7.
 *
 * @author gasieugru
 */
public class Prob1 {

    public static void main(String[] args) {
        Prob1 p = new Prob1();

        System.out.println(p.solution("01010"));
        System.out.println(p.solution("111000"));
        System.out.println(p.solution("111*000"));
        System.out.println(p.solution("110*111000011100000"));
    }

    public int solution2(String s) {
        while (s.contains("01") || s.contains("10")) {
            s = s.replace("01", "").replace("10", "");
        }
        return s.length();
    }

    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length() - 1; i++) {
            if ((sb.charAt(i) == '0' && sb.charAt(i + 1) == '1') ||
                    (sb.charAt(i) == '1' && sb.charAt(i + 1) == '0')) {
                sb.delete(i, i + 2);
                i = Math.max(i - 2, -1); // Move back two positions, considering the removed characters
            }
        }

        return sb.length();
    }


    int countRemoveChar(String s) {
        int[] arr = new int[2];

        for (char c : s.toCharArray()) {
            arr[c - '0']++;
        }

        if (arr[0] == 0 || arr[1] == 0) {
            return 0;
        }

        return Math.abs(arr[0] - arr[1]);
    }

    int solution1(String s) {
        String[] arr = s.contains("*") ? s.split("\\*") : new String[]{s};
        int count = 0;

        for (String str : arr) {
            count += this.countRemoveChar(str);
        }

        return count;
    }

}
