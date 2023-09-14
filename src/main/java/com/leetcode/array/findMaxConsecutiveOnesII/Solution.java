package com.leetcode.array.findMaxConsecutiveOnesII;

/**
 * 487. Max Consecutive Ones II
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 * Example 1:
 * Input: [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 *     After flipping, the maximum number of consecutive 1s is 4.
 *
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,0,1,1,0};
        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int lastZeroIndex = -1;

        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                l = lastZeroIndex + 1;
                lastZeroIndex = r;
            }
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
