package com.coding.java11;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        List<String> list = List.of("Java", "JavaScript");

        String result = list.stream()
                .map((s) -> s.toUpperCase())
                .collect(Collectors.joining(","));

        System.out.println(result);

        Predicate<Integer> addition = (Integer a) -> a > 1;
        String a = null;
        String name = Optional.ofNullable("Java")
                .orElseGet(() -> getRandomName());
    }


    public static String getRandomName() {
        System.out.println("getRandomName() method - start");

        Random random = new Random();
        int index = random.nextInt(5);

        System.out.println("getRandomName() method - end");
        return "";
    }

}
