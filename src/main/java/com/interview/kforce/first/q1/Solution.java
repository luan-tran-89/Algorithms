package com.interview.kforce.first.q1;

/**
 * You are given a string text consisting of English letters and spaces.
 * Find all the capital and lowercase F s in it
 * and insert a capital K right before each one of them.
 *
 * Example:
 * For text = "force", the output should be solution (text) = "Kforce"
 * For text = "fluffy", the output should be solution (text) = "KfluKfKfy"
 *
 * Input/Output:
 *      [execution time limit] 3 seconds (¡ava)
 *      [input] string text
 *          A string consisting of spaces and English letters.
 *      Guaranteed constraints:
 *          1 ≤ text.length ≤ 10^5.
 *
 *      [output] string
 *      A string representing the modified text,
 *      with a k before each capital or lowercase F
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        long start = System.nanoTime();
        System.out.println(s.solution("force"));
        System.out.println(s.solution("fluffy"));
        long end = System.nanoTime();
        System.out.println(end - start);

        long start1 = System.nanoTime();
        System.out.println(s.solution1("force"));
        System.out.println(s.solution1("fluffy"));
        long end1 = System.nanoTime();
        System.out.println(end1 - start1);

    }

    String solution(String text) {
        return text.replaceAll("f", "Kf").replaceAll("F", "KF");
    }

    private static char K = 'K';
    private static char f = 'f';
    private static char F = 'F';

    String solution1(String text) {
        StringBuilder sb = new StringBuilder();
        char[] chars = text.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            Character c = chars[i];
            sb.insert(0, c);
            if (c == f || c == F) {
                sb.insert(0, K);
            }
        }

        return sb.toString();
    }

}
