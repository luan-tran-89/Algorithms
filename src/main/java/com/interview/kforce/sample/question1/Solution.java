package com.interview.kforce.sample.question1;

/**
 * Given a positive integer number n , your task is to calculate the difference
 * between the product of its digits and the sum of its digits.
 * Note: The order matters; the answer should be of the form product - sum
 * (and not sum - product ).
 *
 * Example
 * • For n = 123456, the output should be solution (n) = 699
 *      The product of the digits is equal to 1 * 2 * 3 * 4 * 5 * 6 = 720
 *      The sum of the digits is 1 + 2 + 3 + 4 + 5 + 6 = 21
 *      So the final answer 720 - 21 = 699
 *
 * • For n = 1010, the output should be solution(n) = -2
 *      The product of the digits is equal to 1 * 0 * 1 * 0 = 0
 *      The sum of the digits is 1 + 0 + 1 + 0 = 2
 *      So the final answer 0 - 2 = -2
 *
 * Input/Output
 * • [execution time limit] 3 seconas (ava)
 * • [input] integer n
 *      A positive integer
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(123456));
    }

    int solution(int n) {
        int product = 1;
        int sum = 0;
        int rem = 0;

        while (n > 0) {
            rem = n % 10;
            product *= rem;
            sum += rem;
            n /= 10;
        }

        return product - sum;
    }
}
