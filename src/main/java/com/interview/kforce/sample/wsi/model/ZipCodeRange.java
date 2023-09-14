package com.interview.kforce.sample.wsi.model;

import java.util.Objects;

/**
 * Zip Code Range is a collection of 5-digit ZIP code ranges
 *
 * @author Luan Tran
 */
public class ZipCodeRange {

    public static final String INVALID_ZIP_CODE_RANGE = "Invalid Zip Code Range";
    public static final int ZIP_CODE_MIN = 10000;
    public static final int ZIP_CODE_MAX = 99999;

    private int from;
    private int to;

    public ZipCodeRange(int from, int to) {
        if ((!this.isValidZipCode(from) || !this.isValidZipCode(to) || from > to)) {
            throw new IllegalArgumentException(INVALID_ZIP_CODE_RANGE);
        }
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCodeRange that = (ZipCodeRange) o;
        return from == that.from && to == that.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "ZipCodeRange{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    /**
     * Check the zip code is valid or not.
     * Currently, the zip code has 5-digits format
     *
     * @param zipCode
     * @return true if is valid zip code
     */
    public boolean isValidZipCode(int zipCode) {
        return zipCode >= ZIP_CODE_MIN && zipCode <= ZIP_CODE_MAX;
    }
}
