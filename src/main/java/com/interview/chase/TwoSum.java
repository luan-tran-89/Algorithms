package com.interview.chase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gasieugru
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        List<Integer> list  = List.of(1, 2, 3, 4, 5, 8, 9);
        System.out.println(twoSum.findIndex(list, 8));
    }


    public List<Integer> findIndex(List<Integer> list, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            int key = target - list.get(i);
            if (map.containsKey(key)) {
                return List.of(map.get(key), i);
            }
            map.put(list.get(i), i);
        }

        return null;
    }
}
