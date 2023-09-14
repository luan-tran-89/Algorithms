package com.algo.lab1;

import java.util.*;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] s = {0, 1, 2};
        int[] v = {1, 3, 4};
        int[] w = {1, 2, 4};
        int W = 4;
        System.out.println(Arrays.toString(solution.knapsack(s, v, w, W)));
//        int[] result = solution.knapsack(s, v, w, maxWeight);
//        System.out.println(Arrays.toString(result));
        s = new int[]{0, 1, 2, 3};
        v = new int[]{100, 8, 2, 5};
        w = new int[]{11, 1, 3, 4};
        W = 10;
        System.out.println(Arrays.toString(solution.knapsack(s, v, w, W)));
    }


    public int[] knapsack(int[] s, int[] v, int[] w, int W) {
        List<Set<Integer>> subsets = new ArrayList<>();
        this.knapsack(s, w, W, subsets, new ArrayList<>(), s.length - 1);

        List<Integer> result = new ArrayList<>();
        int maxValue = 0;

        for (Set<Integer> subset : subsets) {
            int value = 0;
            for (int i : subset) {
                value += v[i];
            }

            if (maxValue < value) {
                maxValue = value;
                result = new ArrayList<>(subset);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void knapsack(int[] s, int[] w, int W, List<Set<Integer>> subsets, List<Integer> list, int i) {
        if (W <= 0 || i < 0) {
            if (!list.isEmpty()) {
                subsets.add(new HashSet<>(list));
            }
            return;
        }

        if (w[i] > W) {
            this.knapsack(s, w, W, subsets, list, i - 1);
        } else {
            list.add(s[i]);
            this.knapsack(s, w, W - w[i], subsets, list, i - 1);
            list.remove(list.size() - 1);
        }
    }
}
