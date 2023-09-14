package com.common.collection;

import java.util.*;

/**
 * @author gasieugru
 */
public class SetDemo {

    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("a");
        set.add("b");

        List<String> list = new ArrayList<>(set);
        System.out.println(list.get(0));
    }
}
