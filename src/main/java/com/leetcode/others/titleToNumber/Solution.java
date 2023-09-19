package com.leetcode.others.titleToNumber;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 171. Excel Sheet Column Number
 *
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * Example 1:
 * Input: columnTitle = "A"
 * Output: 1
 *
 * Example 2:
 * Input: columnTitle = "AB"
 * Output: 28
 *
 * Example 3:
 * Input: columnTitle = "ZY"
 * Output: 701
 *
 * Constraints:
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 *
 * @author gasieugru
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1
        System.out.println(s.titleToNumber("A"));
        // 28
        System.out.println(s.titleToNumber("AB"));
        // 701
        System.out.println(s.titleToNumber("ZY"));
        // 2147483647
        System.out.println(s.titleToNumber("FXSHRXW"));
    }

    public int titleToNumber(String columnTitle) {
        int res = 0;
        char[] chars = columnTitle.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            res *= 26;
            res += chars[i] - 'A' + 1;
        }

        return res;
    }
}
