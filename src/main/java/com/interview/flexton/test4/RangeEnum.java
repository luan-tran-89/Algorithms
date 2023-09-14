package com.interview.flexton.test4;

import java.util.stream.Stream;

/**
 * @author gasieugru
 */
public enum RangeEnum {
    RANGE_0_3(0, 3, "5"),
    RANGE_3_7(3, 7, "7"),
    RANGE_7_10(7, 10, "12"),
    RANGE_10_20(10, 20, "15"),
    RANGE_OVER_20(20, Integer.MAX_VALUE, "20");

    int begin;

    int end;

    String value;

    RangeEnum(int begin, int end, String value) {
        this.begin = begin;
        this.end = end;
        this.value = value;
    }

    public static RangeEnum getRange(int number) {
        return Stream.of(RangeEnum.values())
                .filter((e) -> number >= e.begin && number < e.end)
                .findFirst().get();
    }

    @Override
    public String toString() {
        // output - 5, 0.3 - 5
        String endRange = this.end == Integer.MAX_VALUE ? "above" : String.valueOf(this.end);
        return String.format("%s, %s.%s - %s",
                this.value, this.begin, endRange, this.value
        );
    }
}
