package com.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class Solution1 {

    public static void main(String[] args) {
        // [1, 2 ,3, 4, 5]
        // target 5
        // => index 1 & 2
        List<Integer> list  = List.of(1, 2, 3, 4, 5, 8, 9);

        Solution1 solution = new Solution1();
//        System.out.println(solution.findIndex(list, 12));


        // string["flower", "FLOW", "Flight"]
        // => output: fl
        List<String> list1  = List.of("flower", "FLOW", "Flight");
        System.out.println(solution.commonString(list1));
    }

    public String commonString(List<String> list) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

//        List<String> firstStr = list.get(1).chars().mapToObj(c -> String.valueOf(c)).collect(Collectors.toList());

        String minStr = list.get(0);
        int length = list.get(0).length();

        for (String s: list) {
            if (length > s.length()) {
                minStr = s;
                length = s.length();
            }
        }

        List<String> firstStr = minStr.chars().mapToObj(c -> String.valueOf(c + "")).collect(Collectors.toList());
        Character.getName(41);

        for (int i = 0; i < firstStr.size() - 1; i++) {
            for (String s: list) {

                if (!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(firstStr.get(i)))) {
                    return null;
                }
            }
            result.append(firstStr);
        }

        return result.toString();
    }


    // n * n
    public List<Integer> findIndex(List<Integer> list, int target) {
        List<Integer> result  = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = i + 1; j < list.size(); j++) {
                sum = list.get(i) + list.get(j);
                if (sum == target) {
                    return List.of(i, j);
                }
            }
        }

        return result;
    }
}
