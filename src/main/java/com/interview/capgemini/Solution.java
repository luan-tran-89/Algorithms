package com.interview.capgemini;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> list = List.of("d", "o", "e");

//        Comparator<String> comp = (a, b) -> b.compareTo(a);
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        set.add("d");
        set.add("o");
        set.add("e");
        set.add("a");
        set.add("b");

        System.out.println(set);

        SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");

        System.out.println(format.format(new Date()));

//        Locale.get
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        final char[] data = {'a'};
//        List<Integer> even = list1.stream().filter(num -> num % 2 == 0).collect(Collectors.toMap(data++, num -> num));
        Map<String, Integer> even = list1.stream().filter(num -> num % 2 == 0)
                .collect(Collectors.toMap(x -> String.valueOf(data[0]++), Function.identity()));
        System.out.println(even);

        Integer[] a = list1.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(a));

        Optional<String> reduced = set.stream().reduce((s1,s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
    }

}
