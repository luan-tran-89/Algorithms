package com.leetcode.example.insertInterval;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/description/
 * 57. Insert Interval
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Constraints:
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterva = {4,8};
        System.out.println(solution.insert(intervals, newInterva));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] curInterval = intervals[i];

            if (curInterval[1] < newInterval[0]) {
                ans.add(curInterval);
            } else if (curInterval[0] > newInterval[1]) {
                ans.add(newInterval);
                newInterval = curInterval;
            } else if (curInterval[1] >= newInterval[0] || curInterval[0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], curInterval[0]);
                newInterval[1] = Math.max(newInterval[1], curInterval[1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }

}
