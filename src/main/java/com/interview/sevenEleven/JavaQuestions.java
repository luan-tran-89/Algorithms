package com.interview.sevenEleven;

import java.util.*;

/**
 * @author gasieugru
 */
public class JavaQuestions {

    public static void main(String[] args) {
        JavaQuestions.question3();
    }

    public static void question2() {
        Set<String> clubMembers = new HashSet<>(Arrays.asList(
                "Betty",
                "Muffin",
                "Chuck",
                "Steve"
        ));

        Set<String> awardWinners = new HashSet<>(Arrays.asList(
                "Betty",
                "Muffin",
                "Chuck",
                "Steve"
        ));
        clubMembers.retainAll(awardWinners);
        System.out.println(clubMembers);
    }

    public static void question3() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.values().stream().peek(System.out::print).forEach(System.out::print);
    }

}
