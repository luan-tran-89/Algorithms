package com.interview.walmart.demo.subsetSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] S = {7, 3, 2, 5, 8};
        Map<String, Boolean> lookup = new HashMap<>();
        boolean found = solution.subsetSum(S, S.length - 1, 14, lookup);
        System.out.println(found);
    }

    public boolean subsetSum(int[] S, int n, int k, Map<String, Boolean> lookup) {
        if (k == 0) {
            return true;
        }

        if (n < 0 || k <0) {
            return false;
        }

        String key = String.format("%s|%s", n, k);

        if (!lookup.containsKey(key)) {
            boolean include = this.subsetSum(S, n - 1, k - S[n], lookup);
            boolean exclude = this.subsetSum(S, n - 1, k, lookup);
            lookup.put(key, include || exclude);
        }

        return lookup.get(key);
    }

}
