package com.interview.g2o;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        System.out.println(Arrays.toString(duplicateElementArray(array)));
    }

    public static int[] duplicateElementArray(int[] array) {
        return Arrays.stream(array)
                .flatMap(i -> IntStream.of(i, i))
                .toArray();
    }

}
