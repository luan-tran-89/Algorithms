package com.interview.collabera.demo;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        // [1, 3, 6, 2], count = 0
        // => [3, 3, 6, 2], count = 1
        // => [3, 18, 6, 2], count = 2
        // => [3, 18, 12, 2], count = 3
        // => [3, 18, 12, 2], count = 3
        Solution s = new Solution();
//        System.out.println(s.countElements(new int[]{1, 3, 6, 2}));

        System.out.println(s.countElements(new int[]{1, 3, 6, 2}));
    }

    public int countElements(int[] arr) {
        int length = arr.length;
        int count = 0;

        if (length < 2) {
            return count;
        }

        for (int i = 0; ; i++) {
            if (i > length - 2) {
                i = 0;
            }
            int product = arr[i] * arr[i + 1];
            if (product % 3 == 0) {
                arr[i] = product;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public int countElements1(int[] arr) {
        int length = arr.length;
        if(length < 2) {
            return 0;
        }
        int cnt = 0;
        boolean nextRound = true;

        while(nextRound) {
            nextRound = false;

            for(int i = 0; i < length - 1; i++){
                int p = arr[i] * arr[i+1];
                if(p%3 == 0){
                    arr[i] = p;
                    nextRound = true;
                }
            }
            if(nextRound){
                cnt++;
            }
        }
        return cnt;
    }

}
