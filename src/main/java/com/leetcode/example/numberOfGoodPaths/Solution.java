package com.leetcode.example.numberOfGoodPaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-good-paths/
 * 2421. Number of Good Paths
 * There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
 *
 * You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node.
 * You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 *
 * A good path is a simple path that satisfies the following conditions:
 *
 * The starting node and the ending node have the same value.
 * All nodes between the starting node and the ending node have values less than or equal to the starting node
 * (i.e. the starting node's value should be the maximum value along the path).
 * Return the number of distinct good paths.
 * Note that a path and its reverse are counted as the same path. For com.example, 0 -> 1 is considered to be the same as 1 -> 0.
 * A single node is also considered as a valid path.
 *
 * Example 1:
 * Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
 * Output: 6
 * Explanation: There are 5 good paths consisting of a single node.
 * There is 1 additional good path: 1 -> 0 -> 2 -> 4.
 * (The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
 * Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].
 *
 * Example 2:
 * Input: vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]
 * Output: 7
 * Explanation: There are 5 good paths consisting of a single node.
 * There are 2 additional good paths: 0 -> 1 and 2 -> 3.
 *
 * Example 3:
 * Input: vals = [1], edges = []
 * Output: 1
 * Explanation: The tree consists of only one node, so there is one good path.
 *
 * Constraints:
 * n == vals.length
 * 1 <= n <= 3 * 104
 * 0 <= vals[i] <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] vals = new int[]{2,4,1,2,2,5,3,4,4};
        int[][] edges = {{0,1},{2,1},{0,3},{4,1},{4,5},{3,6},{7,5},{2,8}};
        System.out.println(solution.numberOfGoodPaths(vals, edges));
    }

    private int[] root;
    private int[] cnt;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int res = n;
        root = new int[n];
        cnt = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            cnt[i] = 1;
        }

        List<int[]> edgesList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edgesList.add(edges[i]);
        }

        Collections.sort(edgesList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = Math.max(vals[o1[0]], vals[o1[1]]);
                int b = Math.max(vals[o2[0]], vals[o2[1]]);
                if (a < b) {
                    return -1;
                } else if (a > b) {
                    return 1;
                }
                return 0;
            }
        });

        for (int[] edge : edgesList) {
            int x = edge[0];
            int y = edge[1];

            x = this.get(x);
            y = this.get(y);

            if (vals[x] == vals[y]) {
                res += cnt[x] * cnt[y];
                root[x] = y;
                cnt[y] += cnt[x];
            } else if (vals[x] > vals[y]) {
                root[y] = x;
            } else {
                root[x] = y;
            }
        }

        return res;
    }

    private int get(int x) {
        return root[x] == x ? x : (root[x] = this.get(root[x]));
    }

}
