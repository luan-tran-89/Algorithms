package com.leetcode.example.timeBasedKeyValueStore;

import com.leetcode.example.utils.Pair;

import java.util.*;

/**
 * @author gasieugru
 */
public class TimeMap {
    private Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair<String, Integer> pair = new Pair(value, timestamp);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(pair);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        return this.search(map.get(key), timestamp);
    }

    private String search(List<Pair<String, Integer>> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;

        while(start < end) {
            int mid = start + (end - start + 1)/2;
            if (list.get(mid).getValue() <= timestamp) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        Pair<String, Integer> pair =  list.get(start);
        return pair.getValue() <= timestamp ? pair.getKey() : "";
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}
