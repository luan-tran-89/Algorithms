package com.leetcode.example.threeSum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/3sum/
 * 15. 3Sum
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 * Constraints:
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(input));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            int j = i + 1;
            int k = length - 1;
            int first = nums[i];
            if (i > 0 && first == nums[i - 1]) {
                continue;
            }

            while (j < k) {
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

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        Set<List<Integer>> sets = new HashSet<>();

        for (int i= 0; i < length - 2; i++) {
            int first = nums[i];
            // Ignore duplicate value from the top;
            if (i > 0 && first == nums[i-1]) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;
            while(j < k) {
                int second = nums[j];
                int third = nums[k];

                // Ignore duplicate value from the bottom;
                if (k < length - 1 && third == nums[k+1]) {
                    k--;
                    continue;
                }

                int sum = first + second + third;
                if (sum > 0) {
                    // The sum is greater than 0, so we need to reduce the k index
                    k--;
                } else if (sum < 0) {
                    // The sum is less than 0, so we need to increase the j index
                    j++;
                } else {
                    // The sum is 0 => add the result.
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);

                    sets.add(list);
                    j++;
                    k--;
                }
            }
        }

        return sets.stream().toList();
    }
}
