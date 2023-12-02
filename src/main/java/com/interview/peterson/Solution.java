package com.interview.peterson;

/**
 *     Open any Java compiler and write code to solve this problem. Show your screen.
 *
 *     If a=1, b=2, c=3, …………. z= 26, and 1=1, 2=2, 3=3, etc.;
 *     input an alphanumeric string and calculate the sum of that string.
 *
 *     Input: hello123
 *
 *     Output: 58
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(sumOfString("hello123"));
    }

    public static int sumOfString(String str) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char value = str.charAt(i);

            if (value >= 'a' && value <= 'z') {
                sum += value - 'a' + 1;
            }

            if (value >= '1' && value <= '9') {
                sum += value - '1' + 1;
            }
        }

        return sum;
    }

    public static int sumOfString1(String str) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);

            if (value >= 97 && value <= 122) {
                sum += value - 96;
            }

            if (value >= 49 && value <= 57) {
                sum += value - 48;
            }
        }

        return sum;
    }


}
