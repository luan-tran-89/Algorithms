package com.algo.lab1;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author gasieugru
 */
public class Solution2 {

    public static int[] knapsack(int[] s, int[] values, int[] weights, int maxWeight) {
        List<Set<Integer>> subsets = new ArrayList<>();
        knapsackRecursive(s, weights, maxWeight, s.length - 1, new ArrayList<>(), subsets);

        List<Integer> result = new ArrayList<>();
        int maxValue = 0;
        for (Set<Integer> subset : subsets) {
            int value = 0;
            for (int i : subset) {
                value += values[i];
            }
            if (maxValue < value) {
                maxValue = value;
                result = new ArrayList<>(subset);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void knapsackRecursive(int[] s, int[] weights, int maxWeight, int currentIndex, List<Integer> currentSubset, List<Set<Integer>> subsets) {
        if (maxWeight <= 0 || currentIndex < 0) {
            if (!currentSubset.isEmpty()) {
                subsets.add(new HashSet<>(currentSubset));
            }
            return;
        }

        if (weights[currentIndex] > maxWeight) {
            knapsackRecursive(s, weights, maxWeight, currentIndex - 1, currentSubset, subsets);
        } else {
//            knapsackRecursive(s, weights, maxWeight, currentIndex - 1, currentSubset, subsets);

            currentSubset.add(s[currentIndex]);
            knapsackRecursive(s, weights, maxWeight - weights[currentIndex], currentIndex - 1, currentSubset, subsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] s = {0, 1, 2, 3, 4}; // Set of items
        int[] v = {0, 3, 4, 5, 6}; // Values of items
        int[] w = {0, 2, 3, 4, 5}; // Weights of items
        int W = 8;

//        List<Set<Integer>> subsets = knapsack(s, v, w, W);
//        for (Set<Integer> subset : subsets) {
//            System.out.println(subset);
//        }

        s = new int[]{0, 1, 2, 3};
        v = new int[]{100, 8, 2, 5};
        w = new int[]{11, 1, 3, 4};
        W = 10;
        System.out.println(Arrays.toString(knapsack(s, v, w, W)));
    }
}
