package com.leetcode.others.reverseBits;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(Long.parseLong("11111111111111111111111111111101", 2));
//        System.out.println(s.reverseBits(43261596));
        System.out.println(s.reverseBits(4294967293L));
    }

    public int reverseBits(long n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;

            res += n & 1;

            n >>= 1;
        }

        return res;
    }

    public long reverseBits1(long n) {
        int[] bits = this.convertToBits(n);

        StringBuilder sb = new StringBuilder();

        for (int i : bits) {
            sb.append(i);
        }

        return Math.abs(Long.parseLong(sb.toString(), 2));
    }

    private int[] convertToBits(long n) {
        int[] bits = new int[32];
        int i = 0;

        while (n > 0) {
            bits[i++] = (int) n % 2;
            n /= 2;
        }

        return bits;
    }

}
