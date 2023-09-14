package com.interview.sevenEleven;
import java.util.*;
/**
 * @author gasieugru
 */
public class GeneralTree {

    public static int[] ParentNodes(int N, int[][] coordinates) {
        Map<Integer, List<Integer>> graph = new LinkedHashMap<>();

        // Build the graph from the coordinates
        for (int i = 0; i < N - 1; i++) {
            int parent = coordinates[i][0];
            int child = coordinates[i][1];

            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        int[] parents = new int[N];
        parents[0] = -1; // Root node

        int count = 1;

        for (Integer key : graph.keySet()) {
            int length = graph.get(key).size();
            for (int i = 0; i < length; i++) {
                parents[count++] = key;
            }
        }

        return parents;
    }

    private static void assignParents(Map<Integer, List<Integer>> graph, int node, int[] parents) {
        if (graph.containsKey(node)) {
            for (int child : graph.get(node)) {
                parents[child] = node;
                assignParents(graph, child, parents);
            }
        }
    }

    public static int[] ParentNodes1(int N, int[][] coordinates) {
        int[] parent = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : coordinates) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
        }

        dfs(1, -1, graph, parent);

        return parent;
    }

    private static void dfs(int node, int parentNode, ArrayList<Integer>[] graph, int[] parent) {
        parent[node] = parentNode;

        for (int child : graph[node]) {
            if (child != parentNode) {
                dfs(child, node, graph, parent);
            }
        }
    }

    private static void printParentNodes(int[] parentNodes) {
        for (int i = 0; i < parentNodes.length; i++) {
            System.out.println(parentNodes[i]);
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] coordinates = {
                {1, 2},
                {1, 3},
                {2, 4},
                {2, 5}
        };

//        int[] parentNodes = ParentNodes(N, coordinates);
//        printParentNodes(parentNodes);

        int[][] coordinates1 = {
                {1, 12},
                {1, 8},
                {1, 4},
                {12, 3},
                {4, 6},
                {3, 5}
        };
        // -1 1 1 1 12 4 3
//        printParentNodes(ParentNodes(7, coordinates1));

        int[][] coordinates2 = {
            {2, 3}, {2, 6}, {6, 4}, {6, 1}, {3, 5}, {3, 7}
        };
        // 1 2 3 4 5 6 7 - nodes
        // 6   2 6 3 1 3 - parents of nodes
        // -1 6 2 6 3 1 3
        printParentNodes(ParentNodes(7, coordinates2));

        int[][] coordinates3 = {
            {17, 10}, {10, 4}, {4, 2}, {4, 14}, {10, 3}, {3, 9}, {2, 7}, {7, 5}, {7, 18}, {9, 8},
            {2, 12}, {18, 13}, {13, 6}, {10, 1}, {3, 16}, {18, 20}, {17, 19}, {8, 15}, {1, 11}
        };
        // -1 4 10 10 7 13 2 9 3 1 1 2 18 4 8 3 10 7 17 18
//        printParentNodes(ParentNodes(20, coordinates3));
    }
}
