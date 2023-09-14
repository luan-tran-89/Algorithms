package com.leetcode.example.uniqueBinarySearchTrees;


/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * 96. Unique Binary Search Trees
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 *
 * Example 1:
 * Input: n = 3
 * Output: 5
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= n <= 19
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }

    /**
     * G(n): the number of unique BST for a sequence of length n.
     * F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
     *
     * G(n) = F(1, n) + F(2, n) + ... + F(n, n)
     * => G(0) = 1, G(1) = 1    Only a root or empty tree
     *
     * Example: We have [1, 2, 3, 4, 5, 6, 7] with 3 is root
     * => F(3, n) = G(2) * G(4)
     * => F(i, n) = F(i-1) * G(n-i)     1 <= i <= n
     *
     * Finally, Combining the above two formulas:
     * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n-1) * G(0)
     *
     * @param n
     * @return numTrees
     */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;

        for (int i=2; i < n+1; i++) {
            for (int j=1; j <= i; j++) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }

}
