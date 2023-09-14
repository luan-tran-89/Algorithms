package com.interview.flexton.test3;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 *
 * Given an unsorted integer array,Return the smallest missing positive number
 * 	Example: -2, -3, 2, 5, 6, -7, 1
 * 		Output: 3
 *
 * @author gasieugru
 */
public class SmallestMissingNumber {

    public static void main(String[] args) {
        SmallestMissingNumber solution = new SmallestMissingNumber();
        int[] numbers = {-2, -3, 2, 5, 6, -7, 1};
        System.out.println(solution.firstMissingPositive(numbers));

        System.out.println(solution.firstMissingPositive(new int[]{ 0, 10, 2, -10, -20 }));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        boolean [] present = new boolean[1000010];

        // O(n)
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num > 0 && num <= n) {
                present[num] = true;
            }
            max = Math.max(max, num);
        }

        // O(n)
        for (int i = 1; i < present.length; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return max + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums); // O(n * log(n))
        int min = 1;

        for (int num : nums) {
            if (num == min) {
                min++;
            }
        }

        return min;
    }


    public int firstMissingPositive3(int arr[]) {
        int n = arr.length;
        int ptr = 0;

        // Check if 1 is present in array or not
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                ptr = 1;
                break;
            }
        }

        // If 1 is not present
        if (ptr == 0) {
            return (1);
        }

        // Changing values to 1
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = 1;
            }
        }

        // Updating indices according to values
        for (int i = 0; i < n; i++) {
            arr[(arr[i] - 1) % n] += n;
        }

        // Finding which index has value less than n
        for (int i = 0; i < n; i++) {
            if (arr[i] <= n) {
                return (i + 1);
            }
        }

        // If array has values from 1 to n
        return (n + 1);
    }
}
