package com.interview.mitchell;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        input.add(List.of("10"));
        input.add(List.of("2"));
        input.add(List.of("0  China"));
        input.add(List.of("1 Cuba"));
        input.add(List.of("2 -1"));
        input.add(List.of("3 Cuba"));
        input.add(List.of("4 -1"));
        input.add(List.of("5 -1"));
        input.add(List.of("6 Cuba"));
        input.add(List.of("7 Germany"));
        input.add(List.of("8 Germany"));
        input.add(List.of("9 China"));

        List<List<String>> output = Solution.solve1(input);
        print(output);

        System.out.println();

        List<List<String>> input1 = new ArrayList<>();
        input1.add(List.of("0  Bolivia"));
        input1.add(List.of("1 -1"));
        input1.add(List.of("2 -1"));
        input1.add(List.of("3 Cuba"));
        input1.add(List.of("4 China"));
        input1.add(List.of("5 Cuba"));
        input1.add(List.of("6 Argentina"));
        input1.add(List.of("7 Bolivia"));
        input1.add(List.of("8 China"));
        input1.add(List.of("9 -1"));
        print(Solution.solve1(input1));
    }

    private static void print(List<List<String>> output) {
        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j));
                if (j < output.get(i).size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static List<List<String>> solve(List<List<String>> a) {
        Map<String, Integer> map = new HashMap<>();

        List<String> filterList = a.stream()
                .flatMap(s -> s.stream())
                .filter(s -> !s.contains("-1") && s.split("\\s+").length > 1)
                .map(s -> s.split("\\s+")[1])
                .collect(Collectors.toList());

        for (String s : filterList) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> List.of(entry.getKey(), String.valueOf(entry.getValue())))
                .collect(Collectors.toList());
    }

    public static List<List<String>> solve1(List<List<String>> a) {
        return a.stream()
                .flatMap(s -> s.stream())
                .filter(s -> !s.contains("-1") && s.split("\\s+").length > 1)
                .map(s -> s.split("\\s+")[1])
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> List.of(String.format("%s %s", entry.getKey(), entry.getValue())))
                .collect(Collectors.toList());
    }

}
