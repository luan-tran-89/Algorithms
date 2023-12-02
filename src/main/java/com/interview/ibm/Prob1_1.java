package com.interview.ibm;

import java.util.*;

/**
 * @author gasieugru
 */
public class Prob1_1 {

    public static void main(String[] args) {
        System.out.println(subsetA(new ArrayList<>((Arrays.asList(3, 7, 5, 6, 2)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(2, 3, 4, 4, 5, 9, 7, 8, 6, 10, 4, 5, 10, 10, 8, 4, 6, 4, 10, 1)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(5, 5, 5, 10, 10, 10, 11)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(2, 2, 4, 5, 5, 11)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(2, 3, 4, 4, 5, 9, 8, 10, 4, 5, 10, 10, 8, 4, 6, 4, 10, 1)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(2, 5, 5, 9)))));

        System.out.println(subsetA(new ArrayList<>((Arrays.asList(8, 7, 6, 6, 6, 6, 5, 5, 5)))));

    }


    public static List<Integer> subsetA(List<Integer> arr) {
        Collections.sort(arr);

        List<Integer> A = new ArrayList<>();
        int n = arr.size() - 1;
        long total = arr.stream().mapToLong(Integer::longValue).sum();
        long sumA = 0;

        for (int i = n; i > 0; i--) {
            if (sumA <= total - sumA) {
                A.add(arr.get(i));
                arr.remove(i);

                sumA = A.stream().mapToLong(Integer::longValue).sum();
            } else {
                break;
            }
        }

        Collections.sort(A);

        return A;
    }
}
