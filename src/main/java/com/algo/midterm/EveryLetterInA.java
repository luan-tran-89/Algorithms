package com.algo.midterm;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string A with m letters and a string B with n letters, where m <= n. There may be duplicated leters.
 * For example: A (Hello world), B = (He uploads his work).
 * We want to find whether every letter of B is an element of A.
 * Propose an algorithm to solve this problem in O(n) in worst-case running time.
 *
 * @author gasieugru
 */
public class EveryLetterInA {

    public static void main(String[] args) {
        System.out.println(isEveryLetterInA("Hello world", "He uploads his work"));
    }

    public static boolean isEveryLetterInA(String A, String B) {
        Set<Character> letters = new HashSet<>();

        for (int i = 0; i < A.length(); i++) {
            letters.add(A.charAt(i));
        }

        for (int i = 0; i < B.length(); i++) {
            if (!letters.contains(B.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}
