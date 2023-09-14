package com.interview.chase;

import java.util.List;

/**
 * @author gasieugru
 */
public class FindLongestString {

    public static void main(String[] args) {
        FindLongestString solution = new FindLongestString();
        List<String> list = List.of("flower", "FLOW", "Flight");

        String[] arr = {"flower", "FLOW", "Flight"};
        System.out.println(solution.findLongestString(arr));
    }


    public String findLongestString(String[] arr) {
        int n = arr.length;

        String s = arr[0];
        int len = s.length();

        String res = "";

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String stem = s.substring(i, j);
                int k = 1;
                for (; k < n; k++) {
                    if (!arr[k].toLowerCase().contains(stem.toLowerCase())) {
                        break;
                    }
                }

                if (k == n && res.length() < stem.length()) {
                    res = stem;
                }
            }
        }

        return res;
    }
}
