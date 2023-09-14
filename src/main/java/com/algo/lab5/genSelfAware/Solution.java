package com.algo.lab5.genSelfAware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An array A of size n is self-aware if, for each i < n, A[i] is the exact number of occurrences of i in A.
 * Example: A = [2, 0, 2, 0]
 *
 * Write an algorithm accepts a positive integer n as input,
 * when executed, prints out a list of all self-aware arrays of that length.
 *
 * Examples:
 * N = 4
 * {2, 0, 2, 0}
 * {1, 2, 1, 0}
 *
 * N = 5
 * {2, 1, 2, 0, 0}
 *
 * N = 6
 * None
 *
 * N = 7
 * {3, 2, 1, 1, 0, 0, 0}
 *
 * N = 8
 * {4, 2, 1, 0, 1, 0, 0, 0}
 *
 * N = 9
 * {5, 2, 1, 0, 0, 1, 0, 0, 0}
 *
 * N = 10
 * {6, 2, 1, 0, 0, 0, 1, 0, 0, 0}
 *
 * N = 11
 * {7, 2, 1, 0, 0, 0, 0, 1, 0, 0, 0}
 *
 * N = a
 * { a-4, 2, 1, <a-7 0s>, 1, 0, 0, 0 }
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("Generate Self Aware Arrays with length 4");
        generateSelfAwareArrays(4);
        System.out.println("Generate Self Aware Arrays with length 7");
        generateSelfAwareArrays(7);
        System.out.println("Generate Self Aware Arrays with length 10");
        generateSelfAwareArrays(10);
    }

    public static List<int[]> generateSelfAwareArrays(int n) {
        List<int[]> selfAwareArrays = new ArrayList<>();
        int[] currentArray = new int[n];
        generateSelfAwareArrays(selfAwareArrays, currentArray, 0, n);

        for (int[] arr : selfAwareArrays) {
            System.out.println(Arrays.toString(arr));
        }

        return selfAwareArrays;
    }

    public static void generateSelfAwareArrays(List<int[]> selfAwareArrays, int[] currentArray, int currentIndex, int target) {
        if (target < 0) {
            return;
        }
        if (currentIndex == currentArray.length) {
            if (isSelfAware(currentArray)) {
                selfAwareArrays.add(currentArray.clone());
            }
            return;
        }

        for (int i = 0; i < currentArray.length; i++) {
            currentArray[currentIndex] = i;
            generateSelfAwareArrays(selfAwareArrays, currentArray, currentIndex + 1, target - i);
        }
    }

    public static boolean isSelfAware(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int length = arr.length;
        int[] temp = new int[length];

        for (int i = 0; i < length; i++) {
            if (arr[i] >= length) {
                return false;
            }
            temp[arr[i]]++;
        }

        for (int i = 0; i < length; i++) {
            if (temp[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }

}
