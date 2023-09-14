package com.leetcode.example.mySqrt;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.mySqrt(2147483647));
        System.out.println(solution.mySqrt(4));
    }

    public int mySqrt1(int x) {
        if (x < 2) {
            return x;
        }
        double haft = x/2;

        for (int i = 2; i < haft; i++) {
            long pow = (long)i*i;
            if (pow == x) {
                return i;
            } else if (pow > x) {
                return i - 1;
            }
        }

        return haft < 2 ? (int)haft : x / (x/2);
    }

    public int mySqrt(int x) {
        int l = 0, r = 46340;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            int sq = m * m;
            if (sq == x) {
                return m;
            }
            if (sq < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
