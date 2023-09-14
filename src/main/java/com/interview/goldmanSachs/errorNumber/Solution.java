package com.interview.goldmanSachs.errorNumber;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findRange(909));
    }

    public  long findRange(int num) {
        String value = String.valueOf(num);
        Integer firstChar = Character.getNumericValue(value.charAt(0));

        List<Integer> uniqueDigits = value.chars().mapToObj(c -> Character.getNumericValue(c)).distinct().collect(Collectors.toList());
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        System.out.println(uniqueDigits);
        for (Integer digit : uniqueDigits) {
            for (int i = 0; i < 10; i++) {
                boolean isFirstChar = firstChar == digit;
                if (!(isFirstChar && i == 0)) {
                    long number = Long.valueOf(value.replaceAll(String.valueOf(digit), String.valueOf(i)));
                    max = Math.max(max, number);
                    min = Math.min(min, number);
                 }
            }
        }
        return max - min;
    }
}
