package com.interview.sevenEleven.maximizeTotalMarks;

/**
 * Max Marks
 *
 * Exams are going on in a school of N students
 * The question paper consists of 4 sets: A, B, C, and D
 * Given are the marks that each student can score in a question paper set
 *
 * Find the maximum total marks if a student cannot have the same question paper set as the previous student
 *
 * Note:
 *  There cannot be a single student in a school. i.e., N > 1
 *
 *  Example:
 *      N = 4
 *      Number of Question Paper Sets (A, B, C, and D) = 4
 *      The marks are:
 *      10 20 30 40
 *      40 50 20 70
 *      90 100 80 40
 *      20 60 70 10
 *
 * As Student1 scored the maximum marks in set D(i.e., 40), we can go further and see
 * for the next student (i.e., student2)
 *
 * But, if Student1 has set D, Student2 cannot get the question paper set D in which he
 * has scored the maximum marks (i.e. 70).
 * So, we compare their second-best scores such that their sum is maximum.
 *
 * The total sum wil be less in the case if Student1 has set D and student has set B than
 * if Student1 has set C and Student has set D(i.e., 40 + 50) < (30 +70))
 * So, Student1 takes set C and Student2 takes set D, and the maximum sum becomes 30 +70= 100.
 *
 * Now, Student3 takes set B as he scored the maximum in it (i.e., 100),
 * so the sum becomes 30 + 70 + 100 = 200.
 *
 * Now, Student4 takes set C as he scored the maximum in it (i.e. 70),
 * so the sum becomes 30 + 70 + 100 + 70 = 270
 *
 * So, the answer, i.e. the maximum total marks
 * if a student cannot have in the same question paper set as the previous student,
 * becomes 270
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] M = {
                {10, 20, 30, 40},
                {40, 50, 20, 70},
                {90, 100, 80, 40},
                {20, 60, 70, 10},
                {50, 20, 100, 10}
        };
        // Output: 30 + 70 + 90 + 60 + 100 = 350

        // Output: 30 + 70 + 100 + 70 = 270
        System.out.println(s.maximizeTotalMarks(4, M));
    }

    int maximizeTotalMarks(int N, int[][] M) {
        int numberStudents = M.length;
        int[][] dp = new int[numberStudents][N];

        for (int j = 0; j < N; j++) {
            dp[0][j] = M[0][j];
        }

        for (int i = 1; i < numberStudents; i++) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                if (dp[i - 1][j] > max1) {
                    max2 = max1;
                    max1 = dp[i - 1][j];
                } else if (dp[i - 1][j] > max2) {
                    max2 = dp[i - 1][j];
                }
            }

            for (int j = 0; j < N; j++) {
                dp[i][j] = M[i][j] + (dp[i - 1][j] == max1 ? max2 : max1);
            }
        }

        int maxTotalMarks = 0;
        for (int j = 0; j < N; j++) {
            maxTotalMarks = Math.max(maxTotalMarks, dp[numberStudents - 1][j]);
        }

        return maxTotalMarks;
    }

    int maximizeTotalMarks2(int N, int[][] M) {
        int numberStudents = M.length;
        int[][] dp = new int[numberStudents + 1][N];

        for (int i = 1; i <= numberStudents; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = 0; k < N; k++) {
                    if (j != k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + M[i - 1][j]);
                    }
                }
            }
        }

        int maxTotalMarks = 0;
        for (int j = 0; j < N; j++) {
            maxTotalMarks = Math.max(maxTotalMarks, dp[numberStudents][j]);
        }

        return maxTotalMarks;
    }

    public static int maximizeTotalMarks1(int N , int[][] M) {
        int result = -404;



        return result;
    }
}
