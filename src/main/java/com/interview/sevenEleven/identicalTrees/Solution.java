package com.interview.sevenEleven.identicalTrees;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static int identicalTrees(int n, int m, int[][] tree1, int x, int y, int[][] tree2) {
        // Base case: if both trees are null, they are identical
        if (tree1 == null && tree2 == null) {
            return 1;
        }

        // Base case: if one tree is null and the other is not, they are not identical
        if (tree1 == null || tree2 == null) {
            return 0;
        }

        // Base case: if the sizes of the trees are different, they are not identical
        if (n != m) {
            return 0;
        }

        // Check if the root values of both trees are equal
        if (tree1[x][y] != tree2[x][y]) {
            return 0;
        }

        // Recursively compare the left and right subtrees
        int leftSubtree = identicalTrees(n, m, tree1, tree1[x][y + 1], tree1[x][y + 2], tree2);
        int rightSubtree = identicalTrees(n, m, tree1, tree1[x][y + 3], tree1[x][y + 4], tree2);

        // Return true if both subtrees are identical, otherwise false
        return leftSubtree == 1 && rightSubtree == 1 ? 1 : 0;
    }

    public static boolean identicalTrees1(int n, int m, int[][] tree1, int x, int y, int[][] tree2) {
        // Base case: if both trees are null, they are identical
        if (tree1 == null && tree2 == null) {
            return true;
        }

        // Base case: if one tree is null and the other is not, they are not identical
        if (tree1 == null || tree2 == null) {
            return false;
        }

        // Base case: if the sizes of the trees are different, they are not identical
        if (n != m) {
            return false;
        }

        // Check if the root values of both trees are equal
        if (tree1[x][y] != tree2[x][y]) {
            return false;
        }

        // Recursively compare the left and right subtrees
        boolean leftSubtree = identicalTrees1(n, m, tree1, tree1[x][y + 1], tree1[x][y + 2], tree2);
        boolean rightSubtree = identicalTrees1(n, m, tree1, tree1[x][y + 3], tree1[x][y + 4], tree2);

        // Return true if both subtrees are identical, otherwise false
        return leftSubtree && rightSubtree;
    }


    public static int identicalTrees2(int n, int m, int tree1[][], int x, int y, int tree2[][]) {
        if (x >= n || y >= m) {
            // If coordinates are out of bounds, trees can't be identical
            return 0;
        }

        // Compare the nodes at the given coordinates
        int nodeValue1 = tree1[x][y];
        int nodeValue2 = tree2[x][y];

        if (nodeValue1 != nodeValue2) {
            // If node values are different, trees are not identical
            return 0;
        }

        // Recursively check left and right subtrees
        int leftSubtree = identicalTrees2(n, m, tree1, 2 * x + 1, 2 * y, tree2);
        int rightSubtree = identicalTrees2(n, m, tree1, 2 * x + 2, 2 * y, tree2);

        // If both subtrees are identical, the entire trees are identical
        return (leftSubtree == 1 && rightSubtree == 1) ? 1 : 0;
    }
}
