package com.algo.lab4.sort.sortroutines;

import com.algo.lab4.sort.runtime.Sorter;

/**
 * @author gasieugru
 */
public class MergeSortPlus extends MergeSort {

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        theArray = arr;

        if (n <= 20) {
            InsertionSort insertionSort = new InsertionSort();
            theArray = insertionSort.sort(arr);
        } else {
            mergeSort(temp, 0, n - 1);
        }

        return theArray;
    }

    public static void main(String[] args) {
        MergeSortPlus s = new MergeSortPlus();
        int[] arr = {156, 27, 456, 511, 283, 991, 378, 239, 134, 130, 246, 738, 223, 177, 554, 170, 622, 21, 267, 894 };
        long start = System.nanoTime();
        s.sort(arr);
        long end = System.nanoTime();

        System.out.println(end - start);
    }
}
