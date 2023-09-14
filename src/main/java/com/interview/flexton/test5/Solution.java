package com.interview.flexton.test5;

import java.util.Arrays;

/**
 * //Given an array of sorted integers find the index of a given element and print it.
 *
 * E.g find 5 in {1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25}
 * Output 3
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        int[] input = {1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25, 27};
        System.out.println(Solution.findIndex(input, 5));
        Arrays.binarySearch(input, 5);

        String a = "I have experience building applications on both backend and frontend from the scratch, applied responsive websites, dynamic layouts and multiple skins";
        System.out.println(a.split("").length);
    }

    public static int findIndex(int[] array, int value) {
        int length = array.length;
        int begin = 0;
        int end = length - 1;
        int middle = begin + ((end - begin) / 2);

        while(begin <= end) {
            if (array[middle] == value) {
                return middle;
            }

            if (array[middle] > value) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
            middle = begin + ((end - begin) / 2);
        }

        return -1;
    }

}
