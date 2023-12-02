package com.interview.amazon.assessment.test2;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/discuss/general-discussion/1923885/amazon-coding-test-product-ratings-for-n-days-in-a-list-in-on
 *
 * Amazon Shopping recently launched a new item whose daily customer ratings for n days is represented by the array ratings.
 * They monitor these ratings to identify products that are not performing well.
 * Find the number of groups that can be formed consisting of 1 or more consecutive days such that the rating continuously decreases over the days.
 *
 * The rating is consecutively decreasing if it has the form: r, r-1, r-2... and os on, where is the rating on the first day of the group being considered.
 * Two groups are considered different if they contain the ratings of different consecutive days.
 *
 * Example
 *  ratings = [4, 3, 5, 4, 3]
 *  There are 9 periods in which the rating consecutively decreases.
 *      5 one day periods: [4], [3]. [5], [4], [3]
 *      3 two day periods: [4, 3], [5, 4], [4, 3]
 *      1 three day period:[5, 4, 3]
 *  Return: 9
 *
 *  Function Desc:
 *  Complete the function countDecreasingRatings in the editor
 *
 *  countDecreasingRatings contain 1 parameter:
 *      int ratings[n]: customer rating for n days
 *  Returns
 *      long: the number of valid groups of ratings
 *
 * @author gasieugru
 */
public class Prob1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 3, 5, 4, 3);
        System.out.println(countDecreasingRatings(list));

        System.out.println(countGroups(list.stream().mapToInt(i-> i).toArray()));
    }

    public static int countGroups(int[] arr) {
        int groups = 0;
        int start = 0, end = 1;
        while (end < arr.length) {
            //if rating is consecutively decreasing, it is in the same group
            if ((arr[end - 1] - arr[end]) == 1) {
                groups += end - start;
            } else {
                //start new group
                start = end;
            }
            end += 1;
        }
        return groups + arr.length;
    }

    public static long countDecreasingRatings(List<Integer> ratings) {
        int groups = 0;
        int start = 0, end = 1;
        int n = ratings.size();

        while (end < n) {
            //if rating is consecutively decreasing, it is in the same group
            if (ratings.get(end - 1) - ratings.get(end) == 1) {
                groups += end - start;
            } else {
                //start new group
                start = end;
            }
            end += 1;
        }
        return groups + n;
    }

    public static long countDecreasingRatings1(List<Integer> ratings) {
        int seqLength = 0;
        int count = 0;
        boolean seq = false;

        for(int i = 0;i<ratings.size();i++) {
            count++;

            if(i==0) continue;

            seq = ratings.get(i-1) - ratings.get(i) == 1;

            if(!seq) {
                count += seqLength * (seqLength+1)/2;
                seqLength = 0;
            } else {
                seqLength++;
            }
        }

        if(seqLength > 0) {
            count += seqLength * (seqLength+1)/2;
        }
        return count;
    }
}
