package com.interview.photon.countCharacters;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
 *
 * Input:N = 4, K = 6
 * arr[] = {1, 5, 7, 1}
 * Output: 2
 * Explanation:
 * arr[0] + arr[1] = 1 + 5 = 6
 * and arr[1] + arr[3] = 5 + 1 = 6.
 *
 * @author gasieugru
 */
public class PairsCount {

    public static void main(String[] args) {
        PairsCount pairsCount = new PairsCount();
        int[] arr = {1, 5, 7, 1};
        System.out.println(pairsCount.getPairsCount(arr, 4, 6));

        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        System.out.println(simpleDateFormat.format("25-04-2023"));

        List<String> list = List.of("d", "a" , "e");
        Set<String> set = list.stream().collect(Collectors.toCollection(TreeSet::new));

        System.out.println(set);
    }


    int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i])) {
                count += m.get(k - arr[i]);
            }
            if (m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i]) + 1);
            } else {
                m.put(arr[i], 1);
            }
        }
        return count;
	}
}
