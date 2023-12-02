package com.interview.amazon.assessment.test2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2104. Sum of Subarray Ranges
 * https://leetcode.com/problems/sum-of-subarray-ranges/
 *
 * https://leetcode.com/discuss/interview-question/1690696/amazon-onsite-seattle-sde-1-2-dec-2021-reject
 *
 * Amazon Logistics has multiple delivery centers from which products are sent.
 * In one such delivery center, parcels are placed ni a sequence
 * where the parcel has a weight of weight[i].
 * A shipment si constituted of a contiguous segment of parcels.
 * The shipment imbalance of a shipment si defined as the difference
 * between the maximum and minimum weights within a shipment
 *
 * Given the arrangement of parcels, find the sum of shipment imbalance of all the shipments
 * that can be formed from the given sequence of parcels
 *
 * Example
 *  weights=[1, 2, 3]
 *
 *  The shipment imbalance calculations for each possible shipment are shown below.
 *          [1] => 1 - 1 = 0
 *          [2] => 2 - 2 = 0
 *          [3] => 3 - 3 = 0
 *          [1, 2] => 2 - 1 = 1
 *          [2, 3] => 3 - 2 = 1
 *          [1, 2, 3] => 3 - 1 = 2
 *  The total shipment imbalance is 0 + 0 + 0 + 1 + 1 + 2 = 4.
 *
 * Sample Case 0:
 *  weights = [3, 2, 3]
 *  Output: 3
 *      Explanation:
 *          [...] = max - min
 *          [3] => 3 - 3 = 0
 *          [2] => 2 - 2 = 0
 *          [3] => 3 - 3 = 0
 *          [3, 2] => 3 - 2 = 1
 *          [2, 3] => 3 - 2 = 1
 *          [3, 2, 3] => 3 - 2 = 1
 *      => The total imbalance is 0 + 0 + 0 + 1 + 1 + 1 = 3
 *
 * @author gasieugru
 */
public class Prob2 {

    public static void main(String[] args) {
        System.out.println(getTotalImbalance(Arrays.asList(1, 2, 3)));

        System.out.println(getTotalImbalance(Arrays.asList(3, 2, 3)));

        System.out.println(getTotalImbalance(Arrays.asList(5, 4, 6, 13, 14, 3 , 1)));
    }

    public static long getTotalImbalance(List<Integer> weight) {
        long totalImbalance = 0;
        int n = weight.size();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while(!stack.isEmpty() && (i == n || weight.get(stack.peek()) >= weight.get(i))) {
                int mid = stack.peek();
                stack.pop();
                int j = stack.isEmpty() ? -1 : stack.peek();
                totalImbalance -= weight.get(mid) * (j - mid) * (mid - i);
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = 0; i <= n; i++) {
            while(!stack.isEmpty() && (i == n || weight.get(stack.peek()) <= weight.get(i))) {
                int mid = stack.peek();
                stack.pop();
                int j = stack.isEmpty() ? -1 : stack.peek();
                totalImbalance += weight.get(mid) * (j - mid) * (mid - i);
            }
            stack.push(i);
        }

        return totalImbalance;
    }

    public static long getTotalImbalance2(List<Integer> weight) {
        long totalImbalance = 0;
        int length = weight.size();

        for (int i = 0; i < length; i++) {
            int min = weight.get(i);
            int max = weight.get(i);

            for (int j = i; j < length; j++) {
                min = Math.min(min, weight.get(j));
                max = Math.max(max, weight.get(j));
                totalImbalance += max - min;
            }
        }

        return totalImbalance;
    }

    public static long getTotalImbalance1(List<Integer> weight) {
        List<List<Integer>> res = new ArrayList<>();

        subsets(res, new ArrayList<>(), weight, 0);

        int totalImbalance = 0;

        res = res.stream().filter(l -> l.size() > 1).collect(Collectors.toList());

        for (List<Integer> list : res) {
            totalImbalance += list.get(list.size() - 1) - list.get(0);
        }

        return totalImbalance;
    }

    private static void subsets(List<List<Integer>> res, List<Integer> list, List<Integer> weight, int i) {
        if (i == weight.size()) {
            List<Integer> value = new ArrayList<>(list);
//            Collections.sort(value);
            if (!res.contains(value)) {
                res.add(value);
            }
            return;
        }

        list.add(weight.get(i));
        subsets(res, list, weight, i + 1);
        list.remove(list.size() - 1);
        subsets(res, list, weight, i + 1);
    }

}
