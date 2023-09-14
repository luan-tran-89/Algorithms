package com.algo.lab4.exp;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.exp(2, 2));
    }

    long exp(long m, int n) {
        if(n == 0) return 1;				    // 2
        if(n == 1) return m;				    // 2
        if(n % 2 == 0)			                // 2
            return exp(m*m, n/2);		// 3 + T(n/2)
        else
            return exp(m*m, n/2) * m;	// 4 + T(n/2)
    }

}
