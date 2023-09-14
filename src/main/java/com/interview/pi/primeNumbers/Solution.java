package com.interview.pi.primeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * getPrimeNumbers
 *
 * Input: N = 11
 * Output: 2, 3, 5, 7, 11
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getPrimeNumbers(11));
    }


    public List<Integer> getPrimeNumbers1(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int i = 2; i*i < n; i++) {
            if (prime[i]) {
                for (int j = i*i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }


    public List<Integer> getPrimeNumbers(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(x -> isPrime(x))
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(x -> n % x != 0);
    }

}
