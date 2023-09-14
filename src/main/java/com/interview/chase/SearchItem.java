package com.interview.chase;

/**
 * @author gasieugru
 */
public class SearchItem {

    public static void main(String[] args) {
        SearchItem solution = new SearchItem();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(solution.searchItem(arr, 10));
    }

    public int searchItem(int[] arr, int value) {
        return this.searchItem(arr, value, 0, arr.length - 1);
    }

    public int searchItem(int[] arr, int value, int start, int end) {
        if (start > end) {
            return -1;
        }

        if (arr[start] == value) {
            return start;
        }

        if (arr[end] == value) {
            return end;
        }

        return this.searchItem(arr, value, start + 1, end - 1);
    }

}
