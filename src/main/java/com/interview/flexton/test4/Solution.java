package com.interview.flexton.test4;

/**
 * Given the range where the input is falling, return the output value.
 * Data is fixed, and need to optimize for reads what DS and algorithm would you use
 *
 * Input - Double Eg: 0 - output - 5, 0.3 - 5
 * 0 - 3 : 5
 * 3 - 7 : 7
 * 7 - 10: 12
 * 10 - 20 : 15
 * 20 and above : 20
 *
 * @author gasieugru
 */
public class Solution {
//    static Map<RangeEnum, String> map = Map.of(
//            RangeEnum.RANGE_0_3, "5",
//            RangeEnum.RANGE_3_7, "7",
//            RangeEnum.RANGE_7_10, "12",
//            RangeEnum.RANGE_10_20, "15",
//            RangeEnum.RANGE_OVER_20, "20"
//    );

    public static void main(String[] args) {
        System.out.println(RangeEnum.getRange(0));
        System.out.println(RangeEnum.getRange(6));
        System.out.println(RangeEnum.getRange(9));
        System.out.println(RangeEnum.getRange(10));
        System.out.println(RangeEnum.getRange(100));
    }

}
