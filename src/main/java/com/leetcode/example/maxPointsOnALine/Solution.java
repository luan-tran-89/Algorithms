package com.leetcode.example.maxPointsOnALine;


import java.util.*;

/**
 * https://leetcode.com/problems/max-points-on-a-line/description/
 * 149. Max Points on a Line
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
 * return the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 *
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 *
 * Constraints:
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        System.out.println(solution.maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }

        int result = 2;

        for (int i = 0; i<n; i++) {
            Map<Double, Integer> count = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double atan = Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]);
                    count.merge(atan, 1, Integer::sum);
                }
            }
            result = Math.max(result, Collections.max(count.values()) + 1);
        }

        return result;
    }

}
