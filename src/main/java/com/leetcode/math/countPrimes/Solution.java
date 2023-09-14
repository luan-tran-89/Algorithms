package com.leetcode.math.countPrimes;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-primes/description/
 *
 * 204. Count Primes
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 5 * 106
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(10));
    }

    public int countPrimes(int n) {
        int count = 0;
        if (n < 2) {
            return count;
        }

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;

                if((long) i*i < n) {
                    for (int j = i*i; j < n; j+=i) {
                        primes[j] = false;
                    }
                }
            }
        }

        return count;
    }

}
