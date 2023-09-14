package com.leetcode.example.uniquePaths;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        return f(dp,m,n);
    }

    public int f(int dp[][],int m,int n){
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) {
                    continue;
                }
                int up=0,left=0;

                if(i>0) {
                    up=dp[i-1][j];
                }
                if(j>0) {
                    left=dp[i][j-1];
                }
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
}
