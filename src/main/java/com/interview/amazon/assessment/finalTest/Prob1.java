package com.interview.amazon.assessment.finalTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author gasieugru
 */
public class Prob1 {

    public static void main(String[] args) {

        // 1
        System.out.println(getMinimumFruits(List.of(3, 3 , 1, 1, 2)));

        // 0
        System.out.println(getMinimumFruits(List.of(1, 2, 5, 6)));

        // 2
        System.out.println(getMinimumFruits(List.of(2, 2, 2, 5, 1, 2)));

        // 2
        System.out.println(getMinimumFruits(List.of(6, 2, 2, 2, 5, 1, 2)));

    }

    private static int getMinimumFruits1(List<Integer> fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int fruit : fruits) {
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.addAll(map.values());

        while (!heap.isEmpty()) {
            int first = heap.poll();
            if (heap.isEmpty()) {
                return first;
            }
            int second = heap.poll();
            heap.add(first - second);
        }
        return 0;
    }

    private static int getMinimumFruits(List<Integer> fruits) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int fruit : fruits) {
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.addAll(map.values());

        while (!heap.isEmpty()) {
            int first = heap.poll();
            if (heap.isEmpty()) {
                return first;
            }
            int second = heap.poll();
            heap.add(first - second);
        }
        return 0;
    }
}
