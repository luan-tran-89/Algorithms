package com.sort.heap;

import java.util.Arrays;

/**
 * Heap sort is a comparation-based sorting technique based on Binary Heap data structure.
 * It's similar to the seletion sort when we first find the minimum element & place the minimum element at the begining.
 * Repeat the same process for the remaining elements
 *
 * Advantages:
 * - Efficiency
 * - Memory usage
 * - Simplicity
 * Disavanntages:
 * - Costly
 * - Unstable
 * - Efficient: not efficient when working with highly complex data.
 *
 * For com.example: { 12, 11, 13, 5, 6, 7 }
 *      => { 13, 11, 12, 5, 6, 7 }
 *      => { 7, 11, 12, 5, 6, 13 }
 *      => { 12, 11, 7, 5, 6, 13 }
 *      => { 6, 11, 7, 5, 12, 13 }
 *      => { 11, 6, 7, 5, 12, 13 }
 *      => { 5, 6, 7, 11, 12, 13 }
 */
public class HeapSort {
    public void sort(int arr[]) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }
        System.out.println(Arrays.toString(arr));
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
            printArray(arr);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    void heapify(int arr[], int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver's code
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int N = arr.length;

        // Function call
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
