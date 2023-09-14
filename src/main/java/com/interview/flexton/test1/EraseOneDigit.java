package com.interview.flexton.test1;

/**
 * You are given three integers in the form of strings: firstnum, secondnum, and thirdnum.
 * Your task is to check whether it is possible to erase at most one digit from firstnum, so that the resulting string contains at least one digit, has no leading zeros and the value of thirdnum is equal to the sum of the values of firstnum and secondnum.
 *
 * Return true if it's possible, otherwise return false.
 *
 * Note: All three strings are provided without leading zeros.
 *
 * Example
 * For firstnum = "10534", secondnum = "67", and thirdnum = "1120", the output should be solution(firstnum, secondnum, thirdnum) = true.
 *
 * By erasing the 5th digit of firstnum, the result is 1053, and 1053 + 67 = 1120. So the answer is true.
 *
 * For firstnum = "10000", secondnum = "67", and thirdnum = "1120", the output should be solution(firstnum, secondnum, thirdnum) = false.
 * The only possible modified values of firstnum would be 10000 (nothing was deleted), 0000 (first digit was deleted), and 1000 (any zero was deleted); none of which would produce the required sum, so the answer is false.
 *
 * For firstnum = "1067", secondnum = "33", and thirdnum = "100", the output should be solution(firstnum, secondnum, thirdnum) = false.
 * We could delete the first digit of firstnum, resulting in 067 (and 67 + 33 = 100), but since in this case new firstnum value has a leading zero, it's considered invalid. So the answer is false.
 *
 * For firstnum = "153", secondnum = "153", and thirdnum = "306", the output should be solution(firstnum, secondnum, thirdnum) = true.
 * Because 153 + 153 = 306, there's no need to delete a digit from firstnum, and the result is true.
 *
 * @author gasieugru
 */
public class EraseOneDigit {

    public static void main(String[] args) {
        EraseOneDigit solution = new EraseOneDigit();
        System.out.println(solution.eraseOneDigit("10534", "67", "1120"));
        System.out.println(solution.eraseOneDigit("10000", "67", "1s120"));
        System.out.println(solution.eraseOneDigit("1067", "33", "100"));
        System.out.println(solution.eraseOneDigit("153", "153", "306"));
    }

    public boolean eraseOneDigit(String firstnum, String secondnum, String thirdnum) {
        try {
            int second = Integer.parseInt(secondnum);
            int third = Integer.parseInt(thirdnum);
            if (Integer.parseInt(firstnum) + second == third) {
                return true;
            }

            for (int i = 0; i < firstnum.length(); i++) {
                if (i == 0 && firstnum.charAt(1) == '0') {
                    continue;
                }
                StringBuilder sb = new StringBuilder(firstnum);
                int first = Integer.parseInt(sb.deleteCharAt(i).toString());
                if (first + second == third) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
