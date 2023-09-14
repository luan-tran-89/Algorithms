package com.interview.flexton.problem;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problems com.example for Java 8 ::
 * Given a string "This sia eclipse random Eclipse ecliPse not a valid ECLIPSE sdfdsf sdfd",
 * count the number of variations of the word "eclipse" in the string
 * using Java 8 Then count the number of occurrence of each variation, and store them in a map
 *
 * @author gasieugru
 */
public class Problem1 {

    public static void main(String[] args) {
        String input = "This sia eclipse random Eclipse ecliPse not a valid ECLIPSE sdfdsf sdfd";

        Map<String, Integer> map = Stream.of(input.split(" "))
                .filter(s -> s.equalsIgnoreCase("eclipse"))
                .map(String::toLowerCase)
                .collect(Collectors.toMap(s -> s, s -> 1, (s1, s2) -> s1+1));
        System.out.println(map);
    }

}
