package com.interview.sevenEleven.absoluteDiff;

/**
 *
 * Example:
 *      input = "10010"
 *      output = 3
 *
 *      For first 1:
 *          At index 0, 0s on the left is 0 & 1s on the right is 1.
 *          The absolute difference will be |0 - 1| = 1
 *      For second 1:
 *          At index 3, 0s on the left is 2 & 1s on the right is 0.
 *          The absolute difference will be |2 - 0| =
 *      The sum of the absolute difference between the numbers of 0s on the left
 *      and the numbers of 1s on the right for each 1s in the binary string is
 *      1 + 2 = 3
 *
 */
public class Solution {

    public static void main(String[] args) {
        // Input: 1 => Output: -404
//        System.out.println(absoluteDifference("1".length(),"1"));

        // Input: 10010 => Output: 3
        System.out.println(absoluteDifference("10010".length(),"10010"));

        // Input: 000111 => Output: 6
//        System.out.println(absoluteDifference("000111".length(),"000111"));

        // Input: 111000111 => Output: 18
//        System.out.println(absoluteDifference("111000111".length(),"111000111"));


//        System.out.println(absoluteDifference("11000010001".length(),"11000010001"));
    }

    /**
     * Absolute Difference
     * Given a binary string
     * Find the sum of the absolute difference between the numbers of 0s on the left
     * and the number of 1s on the right for each 1s in the binary string
     *
     * @param N length of binary string
     * @param S binary string
     * @return
     * Note: The absolute difference between X and Y is |X - Y|
     */
    public static int absoluteDifference(int N, String S) {
        int result = -404;
        int sum = 0;
        int[] count0 = new int[N];
        int[] count1 = new int[N];

        // Precompute counts
        for (int i = 1; i < N; i++) {
            count0[i] = count0[i - 1] + (S.charAt(i - 1) == '0' ? 1 : 0);
        }

        for (int i = N - 2; i >= 0; i--) {
            count1[i] = count1[i + 1] + (S.charAt(i + 1) == '1' ? 1 : 0);
        }

        // Calculate sum of absolute differences
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '1') {
                sum += Math.abs(count0[i] - count1[i]);
            }
        }

        return sum > 0 ? sum : result;
    }

}
