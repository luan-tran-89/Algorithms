package com.common.longestStringInList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        List<String> list = List.of("Bond", "Einstein", "Alice", "Whitman", "Bob", "Spider");

        // find longest string in an list using Stream max
        String longestString = list.stream()
                .max(Comparator.comparingInt(String::length))
                .get();
        System.out.println(longestString);

        int longestLength = list.stream()
                .map(String::length)
                .max(Integer::compare)
                .get();
        System.out.println(longestLength);

        // find longest string in an list using Sorting
        longestString = list.stream()
                .sorted((s1, s2) -> s1.length() > s2.length() ? -1 : 1)
                .findFirst()
                .get();
        System.out.println(longestString);

        // find longest string in an list using Collections.max()
        longestString = Collections.max(list, Comparator.comparing(String::length));
        System.out.println(longestString);
    }

}
