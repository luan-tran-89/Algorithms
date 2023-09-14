package com.interview.excelacom;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class Solution {
    // input     {1,2,3,4,1,1,1,1,2,6,8,8,8,8,8,8,82,36,8,1}
    // output    {8: 7}

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> list = List.of(1,2,3,4,1,1,1,1,2,6,8,8,8,8,8,8,82,36,8,1);

        System.out.println(s.getNumber(list));
    }

    public int getNumber(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, 1) + 1);
        }

//        int maxOccur = 0;
//        int result = -1;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int value = entry.getValue();
//            if (maxOccur < value) {
//                maxOccur = value;
//                result = entry.getKey();
//            }
//        }

        int result = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(0).getKey();

        return result;
    }

}
