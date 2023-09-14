package com.coding;

import java.util.List;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abc";
        String b = String.valueOf('a');
        List<String> str = s.chars().mapToObj(c -> Character.toString(c)).sorted().toList();
        System.out.println(str);
    }

}
