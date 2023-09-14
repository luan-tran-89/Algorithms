package com.interview.pi.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * getPrimeNumbers
 *
 * Input: N = 7
 * Output: 0, 1, 1, 2, 3, 5, 8
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getFibonacciNumbers(7));
//        String s1 = "YourName";
//        String s2 = "YourName";
//        String s3 = new String("YourName");
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3); // false
//        System.out.println(s1.equals(s2));
    }

    public List<Integer> getFibonacciNumbers(int n) {
        List<Integer> fibonacciNumbers = new ArrayList<>();
        if (n >= 1) {
            int first = 0;
            int second = 1;
            fibonacciNumbers.add(first);
            for (int i = 1; i < n; i++) {
                fibonacciNumbers.add(second);
                int nextNumber = first + second;
                first = second;
                second = nextNumber;
            }

        }
        return fibonacciNumbers;
    }

}
