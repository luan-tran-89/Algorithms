package com.leetcode.array.rotateArray;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/rotate-array/
 * 189. Rotate Array
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 23^1 - 1
 * 0 <= k <= 10^5
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1,2,3,4,5,6,7};
        s.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{-1,-100,3,99};
        s.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2};
        s.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        Map<Integer, Integer> map = new HashMap<>();
        map.computeIfAbsent(1, (v) -> 0);

        List<Integer> res = new ArrayList<>();
        res.add(1);
        System.out.println(Arrays.toString(res.toArray()));

        System.out.println(res.addAll(IntStream.range(0, 3).mapToObj(i -> 3).collect(Collectors.toList())));
        int count = 3;
        int i = 1;
        res.addAll(IntStream.range(0, count).map(n -> i).boxed().collect(Collectors.toList()));
        System.out.println(res);
    }

    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        // If k is greater than length of nums array, we can % to the length to reduce unnecessary rotate
        k %= nums.length;

        // Input: [1,2,3,4,5,6,7]
        // [7, 6, 5, 4, 3, 2, 1]
        this.reserve(nums, 0, n - 1);
        // [5, 6, 7, 4, 3, 2, 1]
        this.reserve(nums, 0, k - 1);
        // [5, 6, 7, 1, 2, 3, 4]
        this.reserve(nums, k, n - 1);
    }

    private void reserve(int[] nums, int start, int end) {
        while ( start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }


    public void rotate1(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length;
        k %= nums.length;
        while (k > 0) {
            System.out.println(k);
            for (int i = n - 1; i >= 0; i--) {
                if (k > 0) {
                    int tmp = nums[n - 1];
                    for (int j = n - 1; j >= 1; j--) {
                        nums[j] = nums[j - 1];
                    }
                    nums[0] = tmp;
                    k--;
                }
            }
        }
    }
}
