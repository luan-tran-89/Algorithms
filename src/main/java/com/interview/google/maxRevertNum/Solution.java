package com.interview.google.maxRevertNum;

/**
 * You have a number between 1 and 1 billion, return the biggest sequence that can be achieved
 * by reverting any subset of the numbers.
 *
 * Examples:
 * - 1394: You can revert 139 so it becomes 9314;
 * - 91423: You can revert 14 so it becomes 41 and you have 94123;
 * - 12413429: You can revert the whole sequence and get 92431421.
 *
 * Couldn't solve it on time, if any one knows how to do it, plz tell me :P
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxVal(1394));
        System.out.println(solution.maxVal(91423));
        System.out.println(solution.maxVal(12413429));
    }

    public int maxVal(int num) {
        int max = 0;
        String val = String.valueOf(num);

        for (int i = 0; i < val.length(); i++) {
            for (int j = i + 1; j < val.length(); j++) {
                if (val.charAt(j) >= val.charAt(i)) {
                    max = Math.max(max, revert(val, i, j));
                }
            }
        }

        return max;
    }

    private int revert(String num, int start, int end) {
        char[] chars = num.toCharArray();

        while(start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }

        return Integer.parseInt(new String(chars));
    }

}
