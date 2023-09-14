package com.interview.coinflip;

/**
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        String[] input = {"4", "1:1", "2:2", "1:2", "0:1"};
//        System.out.println(Solution.ArrayChallenge(input));

//        String[] input1 = {"4", "0:1", "2:2", "1:2", "3:1"};
//        System.out.println(Solution.ArrayChallenge(input1));

        String[] input2 = {"4", "3:1", "2:2", "1:2", "0:1"};
        System.out.println(Solution.ArrayChallenge(input2));
    }

    public static String ArrayChallenge(String[] strArr) {
        String result = "impossible";

        int N = Integer.parseInt(strArr[0]);
        int balance = 0;
        int start = 1;
        int run = start;
        int count = 0;

        while (start <= N) {
            String[] station = strArr[run].split(":");
            balance += Integer.parseInt(station[0]);
            balance -= Integer.parseInt(station[1]);

            run = (run + 1) % N;
            if (run == 0) {
                run = 1;
            }
            count++;

            if (count == N) {
                if (balance < 0) {
                    start++;
                    run = start;
                    balance = 0;
                    count = 0;
                } else {
                    return String.valueOf(start);
                }
            }
        }
        return result;
    }
}
