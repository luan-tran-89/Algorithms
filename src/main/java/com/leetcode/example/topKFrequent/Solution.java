package com.leetcode.example.topKFrequent;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,1,1,2,2,3};
//        int[] nums = {1,2};
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            Integer num = Integer.valueOf(nums[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(m -> m.getKey())
                .collect(Collectors.toList());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).intValue();
        }

        return result;
        // return map.entrySet().stream()
        //     .filter(m -> m.getValue() >= k)
        //     .map(m -> m.getKey())
        //     .mapToInt(Number::intValue).toArray();
    }
}
