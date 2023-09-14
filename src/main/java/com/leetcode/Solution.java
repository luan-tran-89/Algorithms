package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {1 , 2, 3 ,4, 5};
        // Convert array to List
        List<Integer> list1 = Arrays.stream(a).boxed().collect(Collectors.toList());

        List<Integer> list = List.of(2,3,4,5,6);
        // Convert List to array
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(arr));


        Solution solution = new Solution();
        int[] b = {2, 4, 5, 7, 9};
        int[] c = {2, 5, 10, 14, 15};

        System.out.println(Arrays.toString(solution.getUniqueNumbers(a, b, c)));
    }

    public int[] getUniqueNumbers(int[] a, int[] b, int[] c) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        this.putToMap(map, a);
        this.putToMap(map, b);
        this.putToMap(map, c);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            if (count == 1) {
                list.add(entry.getKey());
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private void putToMap(Map<Integer, Integer> map, int[] arr) {
        for (int number : arr) {
            int count = map.get(number) == null ? 0 : map.get(number);
            map.put(number, count + 1);
        }
    }

}
