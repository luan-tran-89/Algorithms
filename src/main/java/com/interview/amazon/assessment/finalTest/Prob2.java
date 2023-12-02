package com.interview.amazon.assessment.finalTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Amazon allows customers to add reviews for the products they bought from their store.
 * The review must follow Amazon's community guidelines in order to be published.
 *
 * Suppose that Amazon has marked n strings that are prohibited in reviews.
 * They assign a score to each review that denotes how well it follows the guidelines.
 * The score of a review is defined as the longest contiguous substring of the review
 * which does not contain any string among the list of n prohibited strings.
 * A string contains a prohibited word if it has a contiguous substring that matches a word from the prohibited list, ignoring the case.
 *
 * Given a review and a list of prohibited strings, calculate the review score.
 *
 * Example:
 *      review = "GoodProductButScrapAfterWash"
 *      prohibitedWords = ["crap", "odpro"]
 *
 *      Some of the substrings that do not contain a prohibited word are:
 *          • ProductBut
 *          • rapAfterWash
 *          • dProductButScu
 *          • Wash
 *      The longest substring is "dProductButScra", return its length, 15.
 *
 * Function Description
 *      Complete the function findReviewScore in the editor below.
 *      findReviewScore has the following parameters:
 *          review: a string
 *          string prohibited Words[n); the prohibited words
 *      Returns
 *          int: the score of the review
 *
 * Sample Case 0:
 *      review = "FastDeliveryOkayProduct"
 *      prohibitedWords = ["eryoka", "yo", "eli"]
 *      => "OkayProduct"
 *
 *      Output: 11
 *
 * Sample Case 1:
 *      review = "ExtremeValueForMoney"
 *      prohibitedWords = ["tuper", "douche"]
 *
 *      Output: 20
 *
 * @author gasieugru
 */
public class Prob2 {

    public static void main(String[] args) {

        // 15
        System.out.println(findReviewScore("GoodProductButScrapAfterWash", List.of("crap", "odpro")));

        // 11
        System.out.println(findReviewScore("FastDeliveryOkayProduct", List.of("eryoka", "yo", "eli")));

        // 20
        System.out.println(findReviewScore("ExtremeValueForMoney", List.of("tuper", "douche")));

    }

    public static int findReviewScore(String review, List<String> prohibitedWords) {
        Set<String> prohibitedSet = new HashSet<>();

        // Add prohibited words to a set for efficient checking
        for (String word : prohibitedWords) {
            prohibitedSet.add(word.toLowerCase());
        }

        int longestSubstring = 0;
        int start = 0;
        int end = 0;

        while (end < review.length()) {
            // Expand the window
            while (end < review.length() && !containsProhibitedWord(review.substring(start, end + 1).toLowerCase(), prohibitedSet)) {
                end++;
            }

            // Update longest substring
            longestSubstring = Math.max(longestSubstring, end - start);

            // Shrink the window
            while (end < review.length() && containsProhibitedWord(review.substring(start, end + 1).toLowerCase(), prohibitedSet)) {
                start++;
            }
        }

        return longestSubstring;
    }

    private static boolean containsProhibitedWord(String substring, Set<String> prohibitedSet) {
        for (String word : prohibitedSet) {
            if (substring.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
