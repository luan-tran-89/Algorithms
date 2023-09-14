package com.interview.walmart.demo.threeSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an array of distinct elements.
 * The task is to find triplets in the array whose sum is zero.
 * Complexity should be less than n^3
 *
 * Examples :
 * Input : arr[] = {0, -1, 2, -3, 1}
 * Output : (0 -1 1), (2 -3 1)
 *
 * Explanation : The triplets with zero sum are
 * 0 + -1 + 1 = 0 and 2 + -3 + 1 = 0
 *
 * Input : arr[] = {1, -2, 1, 0, 5}
 * Output : 1 -2  1
 * Explanation : The triplets with zero sum is
 * 1 + -2 + 1 = 0
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {0, -1, 2, -3, 1};
        System.out.println(s.threeSum(arr));

        System.out.println(s.threeSum(new int[]{1, -2, 1, 0, 5}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(n*logn)

        Set<List<Integer>> result = new HashSet<>();
        int length = nums.length;

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (i > 0 && first == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;

            while(j < k) {
                int second = nums[j];
                int third = nums[k];

                if (k < length - 1 && third == nums[k + 1]) {
                    k--;
                    continue;
                }
                int sum = first + second + third;
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    result.add(List.of(first, second, third));
                    j++;
                    k--;
                }

            }
        }

        return result.stream().collect(Collectors.toList());
    }

}
