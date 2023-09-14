package com.interview.sevenEleven.parentNodes;


import java.util.*;

/**
 * @author gasieugru
 */
public class Solution {
    static Map<Integer, Integer> parents = new HashMap<>();
    public static void ParentNodes(int N, int[][] coordinates) {
        Map<Integer, List<Integer>> graph = new HashMap<>(N);
        for (int[] c : coordinates) {
            graph.computeIfAbsent(c[0], k-> new ArrayList<>()).add(c[1]);
        }
        buildParents(graph, coordinates[0][0]);
        printParent(graph, coordinates[0][0]);
    }

    public static void buildParents(Map<Integer, List<Integer>> g, int v) {
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        while (!queue.isEmpty()) {
            v = queue.poll();
            if (!visitedMap.getOrDefault(v, false)) {
                visitedMap.put(v, true);
                if (g.get(v) != null) {
                    for (Integer w : g.get(v)) {
                        queue.offer(w);
                        parents.put(w, v);
                    }
                }
            }
        }
    }

    public static void printParent(Map<Integer, List<Integer>> g, int v) {
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        Set<Integer> printedParent = new HashSet<>();
        while (!queue.isEmpty()) {
            v = queue.poll();
            if (!visitedMap.getOrDefault(v, false)) {
                visitedMap.put(v, true);
                int parent = parents.getOrDefault(v, -1);
                if (!printedParent.contains(parent)) {
                    System.out.println(parent);
                    printedParent.add(parent);
                }
                if (g.get(v) != null) {
                    for (Integer w : g.get(v)) {
                        queue.offer(w);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ParentNodes(5, new int[][]{{1,2},{1,3}, {2,4}, {2, 5}});

//        ParentNodes(7, new int[][]{{1,4},{1,8}, {1,12}, {12, 3}, {3, 5}, {4, 6}});
    }
}