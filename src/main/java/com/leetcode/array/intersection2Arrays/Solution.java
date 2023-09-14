package com.leetcode.array.intersection2Arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays
 * and you may return the result in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(s.intersect(nums1, nums2)));
        System.out.println(Arrays.toString(s.intersect1(nums1, nums2)));

        nums1 = new int[]{4,9,5};
        nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(s.intersect(nums1, nums2)));
        System.out.println(Arrays.toString(s.intersect1(nums1, nums2)));
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        int[] tmp1 = new int[1001];
        int[] tmp2 = new int[1001];
        List<Integer> res = new ArrayList<>();

        for (int num : nums1) {
            tmp1[num] += 1;
        }

        for (int num : nums2) {
            tmp2[num] += 1;
        }

        for (int i = 0; i < tmp1.length; i++) {
            if (tmp1[i] > 0 && tmp2[i] > 0) {
                int count = Math.min(tmp1[i], tmp2[i]);
                for (int j = 0; j < count; j++) {
                    res.add(i);
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> tmp1 = new HashMap<>();
        Map<Integer, Integer> tmp2 = new HashMap<>();

        for (int num : nums1) {
            tmp1.put(num, tmp1.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            tmp2.put(num, tmp2.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> map = tmp1.size() > tmp2.size() ?  tmp1 : tmp2;
        for (Integer key : map.keySet()) {
            if (tmp1.getOrDefault(key, 0) > 0 && tmp2.getOrDefault(key, 0) > 0) {
                int count = Math.min(tmp1.get(key), tmp2.get(key));
                for (int j = 0; j < count; j++) {
                    res.add(key);
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
