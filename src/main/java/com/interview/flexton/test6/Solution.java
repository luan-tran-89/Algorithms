package com.interview.flexton.test6;

import java.util.ArrayList;
import java.util.List;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * https://leetcode.ca/2016-10-18-323-Number-of-Connected-Components-in-an-Undirected-Graph/
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 *      0          3
 *      |          |
 *      1 --- 2    4
 * Output: 2
 *
 * Example 2:
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 * Output:  1
 *
 * Note:
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {{0,1}, {1,2}, {2,3}, {3,4}};
        System.out.println(s.countComponents(5, input));

        input = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println(s.countComponents(5, input));
    }

    private int[] p;

    public int countComponents1(int n, int[][] edges) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            p[find(a)] = find(b);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i == find(i)) {
                ++ans;
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public int countComponents(int n, int[][] edges) {
        int res = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int[] a : edges) {
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }

        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                res++;
                dfs(edges, visited, i);
            }
        }

        return res;
    }

    private void dfs(int[][] edges, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;

        if (i < edges.length) {
            for (int j = 0; j < edges[i].length; j++) {
                dfs(edges, visited, edges[i][j]);
            }
        }
    }

}
