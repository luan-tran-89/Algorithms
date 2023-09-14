package com.test;

import java.time. format. DateTimeFormatter;
import java. time. LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author gasieugru
 */
public class Test {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2015, 4, 4);
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("E, MMM dd, yyyy")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")));


        List<String> list = Arrays.asList("dog", "over", "good");

        System.out.println(list.stream().reduce(new String(), (x1, x2) -> {
            if (x1.equals("dog"))
                return x1;
            return x2;
        }));
    }

}
