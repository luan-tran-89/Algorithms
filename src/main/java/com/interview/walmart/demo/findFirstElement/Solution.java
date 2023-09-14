package com.interview.walmart.demo.findFirstElement;

/**
 * https://www.geeksforgeeks.org/first-strictly-greater-element-in-a-sorted-array-in-java/
 *
 * Given a sorted array and a target value,
 * find the first element that is strictly greater than given element.
 *
 * Examples:
 * Input : arr[] = {1, 2, 3, 5, 8, 12}
 *         Target = 5
 * Output : 4 (Index of 8)
 *
 * Input : {1, 2, 3, 5, 8, 12}
 *         Target = 8
 * Output : 5 (Index of 12)
 *
 * Input : {1, 2, 3, 5, 8, 12}
 *         Target = 15
 * Output : -1
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.next(new int[] {1, 2, 3, 5, 8, 12}, 5));
        // s = 0, e = 5, m = 2, arr[m] = 3 => s = 3
        // s = 3, e = 5, m = 4, arr[m] = 8 => res = 4, e = 3 => stop

        System.out.println(s.next(new int[] {1, 2, 3, 5, 8, 12}, 8));
        // s = 0, e = 5, m = 2, arr[m] = 3
        // s = 3, e = 5, m = 4, arr[m] = 8 => s = 4
        // s = 4, e = 5, m = 4, arr[m] = 8 => s = 5
        // s = 5, e = 5, m = 5, arr[m] = 12 => res = 12, e = 4 => stop

        System.out.println(s.next(new int[] {1, 2, 3, 5, 8, 12}, 15));
        // s = 0, e = 5, m = 2, arr[m] = 3
        // s = 3, e = 5, m = 4, arr[m] = 8 => s = 4
        // s = 4, e = 5, m = 4, arr[m] = 8 => s = 5
        // s = 5, e = 5, m = 5, arr[m] = 12 => s = 6 => stop
    }

    public int next(int[] arr, int target) {
        int result = -1;
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) /2;

            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }

}
