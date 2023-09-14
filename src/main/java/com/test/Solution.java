package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gasieugru
 */
public class Solution {

    public String test;

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> lines = new ArrayList<>();
        lines.add("a");
        lines.add("b");
        lines.add("c");

        System.out.println(lines.stream().filter(line -> line.startsWith("a")).findFirst().get());
    }
}
