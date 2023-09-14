package com.interview.flexton.meetingRoomsII;

import java.util.Map;
import java.util.TreeMap;

/**
 * Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/
 * https://aaronice.gitbook.io/lintcode/sweep-line/meeting-rooms-ii
 *
 * Given an array of meeting time intervals consisting of start
 * and end times[[s1,e1],[s2,e2],...](si< ei),
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 * Input: [[7,10],[2,4]]
 * Output: 1
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s1 = new Solution();
        Interval[] intervals = {
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)
        };

        System.out.println(s1.minMeetingRooms(intervals));

        Interval[] intervals1 = {
                new Interval(7, 10),
                new Interval(2, 4)
        };
        System.out.println(s1.minMeetingRooms(intervals1));

        System.out.println(s1.minMeetingRooms(new int[][] {
                {0, 30}, {5, 10}, {15, 20}
        }));
    }

    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        int result = 0;
        int count = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            result = Math.max(result, count);
        }

        return result;
    }

    /**
     * Explain:
     *  Input: [[0, 30],[5, 10],[15, 20]]
     *
     *  TreeMap:
     *      <0, 1>
     *      <5, 1>
     *      <10, -1>
     *      <15, 1>
     *      <20, -1>
     *      <30, -1>
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int result = 0;
        int count = 0;

        for (Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        for (int k : map.keySet()) {
            count += map.get(k);
            result = Math.max(result, count);
        }

        return result;
    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
