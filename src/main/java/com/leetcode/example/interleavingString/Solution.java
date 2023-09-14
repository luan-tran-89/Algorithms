package com.leetcode.example.interleavingString;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] db = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    db[i][j] = true;
                } else {
                    char currentS3Char = s3.charAt(i + j - 1);
                    db[i][j] = (j > 0 && db[i][j - 1] && s2.charAt(j - 1) == currentS3Char) ||
                            (i > 0 && db[i - 1][j] && s1.charAt(i - 1) == currentS3Char);

//                    if (i == 0) {
//                        db[i][j] = db[i][j - 1] && s2.charAt(j - 1) == currentS3Char;
//                    } else if (j == 0) {
//                        db[i][j] = db[i - 1][j] && s1.charAt(i - 1) == currentS3Char;
//                    } else {
//                        db[i][j] = (db[i][j - 1] && s2.charAt(j - 1) == currentS3Char) ||
//                                    (db[i - 1][j] && s1.charAt(i - 1) == currentS3Char);
//                    }
                }
            }
        }

        return db[s1.length()][s2.length()];
    }
}
