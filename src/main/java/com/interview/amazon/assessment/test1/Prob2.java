package com.interview.amazon.assessment.test1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-total-strength-of-wizards/
 *
 * https://leetcode.com/discuss/interview-question/1759431/amazon-oa-sum-of-server-powers
 *
 * Amazon Web services has n servers.
 * The cache optimization power of the ith server is power[i].
 * The cache optimization power of a group of contiguous servers [I, r] is defined as
 *
 * Find the sum of Power, for each possible contiguous group of servers.
 * Since, the answer can be very large, return the answer
 *  modulo 1000000007(10^9 +7)
 *
 * Example:
 *  power = [2, 3, 2, 1]
 *
 *  There are n = 4 servers.
 *  The powers of contiguous groups of servers are:
 *      Power [0, 0] = min([2]) * sum([2]) = 2 * 2 = 4
 *      Power [0,1] = min([2, 3]) * sum([2, 3]) = 2 * 5 = 10
 *      Power [0,2] = min([2, 3, 2]) * sum([2, 3, 2]) = 2 * 7 = 14
 *      Power [0,3] = min([2, 3, 2, 1]) * sum([2, 3, 2, 1]) = 1 * 8 = 8
 *      Power [1,1] = min([3]) * sum([3]) = 3 * 3 = 9
 *      Power [1,2] = min([3, 2]) * sum([3, 2]) = 2 * 5 = 10
 *      Power [1,3] = min([3, 2, 1]) * sum([3, 2, 1]) = 1 * 6 = 6
 *      Power [2,2] = min([2]) * sum([2]) = 2 * 2 = 4
 *      Power [2,3] = min([2, 1]) * sum([2, 1]) = 1 * 3 = 3
 *      Power [3,3] = min([1]) * sum([1]) = 1 * 1 = 1
 *
 *      Overall sum: 69
 *      Return 69 modulo (10^9 + 7) = 69
 *
 * Sample Case 0:
 *      power = [2, 1, 3]
 *      Output: 27
 *
 * Sample Case 11
 *      power = [2, 4]
 *      Output: 32
 *
 *      Explanation
 *          Power [0,0] = min([2]) * sum ([2]) = 2 * 2 = 4
 *          Power [0,1] = min([2, 4]) * sum([2, 4]) = 2 * 6 = 12
 *          Power [1,1] = min([4]) * sum([4]) = 4 * 4 = 16
 *
 *          Overall sum: 32
 *          Return 32 modulo (10^9 + 7) = 32
 *
 * @author gasieugru
 */
public class Prob2 {

    public static void main(String[] args) {
        System.out.println(findTotalPower(Arrays.asList(2, 3, 2, 1)));

        System.out.println(findTotalPower(Arrays.asList(2, 1, 3)));

        System.out.println(findTotalPower(Arrays.asList(2, 4)));
    }

    public static int findTotalPower(List<Integer> power) {
        int result = 0, sum = 0;
        int mod = 1000000007;
        int n = power.size();
        Deque<Integer> minStack = new LinkedList<>();
        int[] sumPrefix = new int[n + 2];

        for (int r = 0; r <= n; r++) {
            int w = r < n ? power.get(r) : 0;
            sum = (sum + w) % mod;
            sumPrefix[r + 1] = (sum + sumPrefix[r]) % mod;
            while (!minStack.isEmpty() && power.get(minStack.peekFirst()) > w) {
                int top = minStack.pop();
                int l = minStack.isEmpty() ? -1 : minStack.peek();
                long left_sum = l < 0 ? sumPrefix[top] : sumPrefix[top] - sumPrefix[l];
                long right_sum = sumPrefix[r] - sumPrefix[top];
                int ln = top - l, rn = r - top;
                result = (int)(result + (right_sum * ln - left_sum * rn) % mod * power.get(top) % mod) % mod;
            }
            minStack.push(r);
        }

        return (result + mod) % mod;
    }
}