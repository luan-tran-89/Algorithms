package com.algo.lab4.sort.sortroutines;

import com.algo.lab4.sort.runtime.Sorter;

import java.util.Arrays;

/**
 * @author gasieugru
 */
public class MergeSort extends Sorter {

    int[] theArray;


    public static void main(String[] args) {
        MergeSort s = new MergeSort();

        int[] arr = {156, 27, 456, 511, 283, 991, 378, 239, 134, 130, 246, 738, 223, 177, 554, 170, 622, 21, 267, 894 };
        long start = System.nanoTime();
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
        long end = System.nanoTime();

        System.out.println(end - start);
    }

    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        int[] tempStorage = new int[n];
        theArray = arr;
        mergeSort(tempStorage, 0, n - 1);
        return theArray;
    }

    void mergeSort(int[] temp, int lower, int upper) {
        if (lower == upper) {
            return;
        } else {
            int mid = (lower + upper) / 2;
            mergeSort(temp, lower, mid);
            mergeSort(temp, mid + 1, upper);
            merge(temp, lower, mid + 1, upper);
        }
    }

    public void merge(int[] tempStorage,
                      int lowerPointer,
                      int upperPointer,
                      int upperBound) {
        int j = 0; //tempStorage index
        int lowerBound = lowerPointer;
        //total number of elements to rearrange
        int n = upperBound - lowerBound + 1;
        //view the range [lowerBound,upperBound] as two arrays
        //[lowerBound, mid], [mid+1,upperBound] to be merged
        int mid = upperPointer - 1;
        while (lowerPointer <= mid && upperPointer <= upperBound) {
            if (theArray[lowerPointer] <= theArray[upperPointer]) {
                tempStorage[j++] = theArray[lowerPointer++];
            } else {
                tempStorage[j++] = theArray[upperPointer++];
            }
        }
        //left array may still have elements
        while (lowerPointer <= mid) {
            tempStorage[j++] = theArray[lowerPointer++];
        }
        //right array may still have elements
        while (upperPointer <= upperBound) {
            tempStorage[j++] = theArray[upperPointer++];
        }
        //replace the range [lowerBound,upperBound] in theArray with
        //the range [0,n-1] just created in tempStorage
        for (j = 0; j < n; ++j) {
            theArray[lowerBound + j] = tempStorage[j];
        }
    }

}
