package com.leetcode.others.isHappy;

/**
 * https://leetcode.com/problems/happy-number/
 * 202. Happy Number
 *
 * Explanation:
 *  https://leetcode.com/problems/happy-number/solutions/3767573/easy-java-solution-two-pointers-floyd-s-tortoise-and-hare-detailed-explanation/
 *  https://leetcode.com/problems/happy-number/solutions/3920159/js-simple-two-pointer-floyd-s-cycle-explanation/
 *
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * Constraints:
 * 1 <= n <= 2^31 - 1
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        // true
        System.out.println(s.isHappy(19));
        // false
        // 2 => 4
        // 4 => 4^2 = 16
        // 16 => 1 + 36 = 37
        // 37 => 9 + 49 = 58
        // 58 => 5^2 + 8^2 = 89
        // => (loop)
        System.out.println(s.isHappy(2));
        // true
        System.out.println(s.isHappy(7));
        // false
        System.out.println(s.isHappy(4));

        // false => special case because this has something to do with cycle.
        // 12 => 1^2 + 2^2 = 5
        // 5 => 5^2 = 25
        // 25 => 2^2 + 5^2 = 29
        // 29 => 2^2 + 9^2 = 89     (loop)
        // 89 => 8^2 + 9^2 = 145
        // 145 => 1 + 4^2 + 5^2 = 42
        // 42 => 4^2 + 2^2 = 20
        // 20 => 2^2 = 4
        // 4 => 4^2 = 16
        // 16 => 1 + 6^2 = 37
        // 37 => 3^2 + 7^2 = 58
        // 58 => 5^2 + 8^2 = 89
        // 89 => (loop)
        System.out.println(s.isHappy1(12));
    }

    public boolean isHappy1(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquare1(slow);
            fast = sumOfSquare1(sumOfSquare1(fast));
        } while(slow != fast);

        return slow == 1;
    }

    private int sumOfSquare1(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquare(slow);
            fast = sumOfSquare(sumOfSquare(fast));
        } while(slow != fast);

        return slow == 1;
    }

    private int sumOfSquare(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 2);
            n = n / 10;
        }

        return sum;
    }

}
