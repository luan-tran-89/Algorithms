package com.interview.sevenEleven.bridgeIslands;

import java.util.*;

/**
 *
 * Graphs: Optimal Path
 * There is a total of N number of islands numbered from 1to N.
 * Some pairs fo islands aer connected by M number of bidirectional bridges running over water.
 * Crossing these bridges requires a olt of time. You are standing at island 1and must reach island
 *
 * Find the minimum number of bridges you must cross if you take the optimal route.
 *
 * Input Format
 * The first line contains two space-separated integers, N and M, denoting het number of islands and the number of bridges.
 * Each of the next M lines contains two space-separated Integers, X and ,Y denoting
 * that there is a bridge between island X and island Y
 *
 * Sample Input:
 *  3 2 -- denotes N and M
 *  1 2 -- denotes X and Y
 *  2 3 -- denotes X and Y
 *
 * OutputFormat
 *  The output contains a single integer denoting the minimum number of bridges uoy must cross if you take the optimal route.
 *
 * SampleOutput:
 *  2
 *
 * Explanation
 *  After drawing a graph from the given input, we can se that if you must react Island 3, you must cross 2 bridges
 *      1 <---> 2 <---> 3
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        int[][] bridges = {
                {1, 2},
                {2, 3}
        };

        System.out.println(bridgeIslands(3, 2, bridges));
    }

    static class Graph {
        Map<Integer, List<Integer>> adjList;

        Graph() {
            adjList = new HashMap<>();
        }

        void addEdge(int x, int y) {
            adjList.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            adjList.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
    }

    static int bridgeIslands(int N, int M, int[][] bridges) {
        Graph graph = new Graph();

        for (int[] bridge : bridges) {
            int x = bridge[0];
            int y = bridge[1];
            graph.addEdge(x, y);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int island = current[0];
            int steps = current[1];
            visited.add(island);

            if (island == N) {
                return steps;
            }

            List<Integer> neighbors = graph.adjList.getOrDefault(island, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(new int[]{neighbor, steps + 1});
                }
            }
        }

        return -1;
    }

}
