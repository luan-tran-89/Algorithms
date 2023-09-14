package com.interview.flexton.test1;

/**
 * kth largest element in BST, do it without using global variable.
 *
 * https://afteracademy.com/blog/kth-largest-element-in-a-bst/
 * https://www.geeksforgeeks.org/kth-largest-element-bst-using-constant-extra-space/
 * @author gasieugru
 */
public class KthLargestInBST {

    static class Node {
        int data;
        Node left, right;
    }

    // helper function to create a new Node
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.right = null;
        temp.left = null;
        return temp;
    }

    public static void main(String[] args) {
        // Your Java Code
        /* Constructed binary tree is
             4
            / \
           2   7
          / \ / \
         1  3 6 10
        */

        Node root = newNode(4);
        root.left = newNode(2);
        root.right = newNode(7);
        root.left.left = newNode(1);
        root.left.right = newNode(3);
        root.right.left = newNode(6);
        root.right.right = newNode(10);

        System.out.println("Finding K-th largest Node in BST : " +
                KthLargestUsingMorrisTraversal(root, 2));
    }

    /**
     * Using Reverse Morris Traversal
     *
     * @param root
     * @param k
     * @return
     */
    static int KthLargestUsingMorrisTraversal(Node root, int k) {
        Node current = root;
        Node KthLargest = null;

        // count variable to keep count of visited Nodes
        int count = 0;

        while(current != null) {
            // if right child is NULL
            if(current.right == null) {
                // first increment count and check if count = k
                count++;
                if(count == k) {
                    KthLargest = current;
                }
                // otherwise move to the left child
                current = current.left;
            } else {
                // find inorder successor of current Node
                Node successor = current.right;
                while (successor.left != null && successor.left != current) {
                    successor = successor.left;
                }
                if (successor.left == null) {
                    // set left child of successor to the
                    // current Node
                    successor.left = current;
                    // move current to its right
                    current = current.right;
                } else {
                    // restoring the tree back to original binary
                    // search tree removing threaded links
                    successor.left = null;
                    count++;
                    if(count == k) {
                        KthLargest = current;
                    }
                    // move current to its left child
                    current = current.left;
                }
            }
        }
        return KthLargest.data;
    }

}
