package com.interview.sevenEleven.maximizeTotalMarks;

/**
 * @author gasieugru
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] M = {
                {10, 20, 30, 40},
                {40, 50, 20, 70},
                {90, 100, 80, 40},
                {20, 60, 70, 10}
        };

        // Explanation:
        /**
         * Output: 30 + 70 + 100 + 70 = 270
         * Explanation:
         *      Using dynamic programing with extra space
         *      int[][] dp = new int[M.length][N];
         *
         *      Step 1: add student 1 data to dp
         *      Step 2: Find maximum marks for the next student
         *          - Find max value & second max value
         *          - Add the next row for dp with conditions:
         *              - If dp[i - 1][j] is a max value, we will sum the mark of current student to second max
         *              - Otherwise, we will sum the mark of current student to max value
         *      Step 3: Find the max value in the last row (dp[N - 1])
         *
         *      Step 1:
         *          dp = [
         *              [10, 20, 30, 40],
         *              [0, 0, 0, 0],
         *              [0, 0, 0, 0],
         *              [0, 0, 0, 0]
         *          ];
         *
         *      Step 2:
         *          Loop 1: start at i = 1
         *              Find max1 & max2 in row 0
         *                  => max1 = 40, max2 = 30
         *              Generate data to row 1
         *                  dp = [
         *                        [10, 20, 30, 40],
         *                        [80, 90, 60, 100],
         *                        [0, 0, 0, 0],
         *                        [0, 0, 0, 0]
         *                    ];
         *          Loop 2: i = 2
         *              Find max1 & max2 in row 1
         *                  => max1 = 100, max2 = 90
         *              Generate data to row 2
         *                  dp = [
         *                      [10, 20, 30, 40],
         *                      [80, 90, 60, 100],
         *                      [190, 200, 180, 130],
         *                      [0, 0, 0, 0]
         *                  ];
         *          Loop 3: i = 3
         *              Find max1 & max2 in row 1
         *                  => max1 = 200, max2 = 190
         *              Generate data to row 3
         *                  dp = [
         *                      [10, 20, 30, 40],
         *                      [80, 90, 60, 100],
         *                      [190, 200, 180, 130],
         *                      [220, 250, 270, 210],
         *                  ]
         *          End Loop
         *      Step 3: Find the max value in the last row of dp
         *          [220, 250, 270, 210]
         *          => result = 270
         */
        System.out.println(s.maximizeTotalMarks(4, M));
    }

    int maximizeTotalMarks(int N, int[][] M) {
        int length = M.length;
        int[][] dp = new int[length][N];

        for (int j = 0; j < N; j++) {
            dp[0][j] = M[0][j];
        }

        for (int i = 1; i < length; i++) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                int value = dp[i-1][j];
                if (value > max1) {
                    max2 = max1;
                    max1 = value;
                } else if (value > max2) {
                    max2 = value;
                }
            }

            for (int j = 0; j < N; j++) {
                int previous = dp[i - 1][j] == max1 ? max2 : max1;
                dp[i][j] = M[i][j] + previous;
            }
        }

        int result = 0;
        for (int j = 0; j < N; j++) {
            result = Math.max(result, dp[length - 1][j]);
        }

        return result;
    }

}
