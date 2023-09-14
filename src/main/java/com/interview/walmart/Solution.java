package com.interview.walmart;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [1,3,5,6], target = 5
 * i = 0
 * j = length - 1 = 3
 * => mid = 1
 *
 * i = mid + 1 = 2
 * j = length - 1 = 3
 *
 * mid = 2 => arr[2] = 5 => mid
 *
 * Output: 2
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,5,6};

        System.out.println(s.findValue(nums, 5));
        System.out.println(s.findValue(nums, 2));
        //{1,3,5,6}
        // 2 + 4 => 6
        System.out.println(s.findValue1(nums, 7));
        System.out.println(s.findValue(new int[]{}, 7));
        System.out.println(s.findValue(nums, 0));

        System.out.println(s.findValue(new int[]{1,2,4,5,6}, 5));
    }

    public int findValue1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] > target) {
            return start;
        } else if (nums[start] < target && nums[end] >= target) {
            return end;
        }

        return end + 1;
    }

    public int findValue(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;

        if (nums == null || nums.length == 0 || target < nums[i]) {
            return i;
        }

        if (j > 0 && target > nums[j]) {
            return j + 1;
        }

        // O (log n)
        while(i < j) {
            mid = (j + i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target ) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return mid;
    }

}
