package com.interview.kforce.wsi.model;

import java.util.Random;

import com.interview.kforce.sample.wsi.model.ZipCodeRange;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 *
 * @author Luan Tran
 */
public class ZipCodeRangeTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidZipCodeRange_RangeExceed() {
        Random random = new Random();
        int from = ZipCodeRange.ZIP_CODE_MAX + random.nextInt(1000);
        int to = ZipCodeRange.ZIP_CODE_MAX + random.nextInt(1000);

        new ZipCodeRange(from, to);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidZipCodeRange_FromGreaterThanTo() {
        Random random = new Random();
        int from = ZipCodeRange.ZIP_CODE_MIN + random.nextInt(1000);
        int to = from - 1;

        new ZipCodeRange(from, to);
    }

    @Test
    public void testEquals() {
        int from = ZipCodeRange.ZIP_CODE_MIN;
        int to = ZipCodeRange.ZIP_CODE_MAX;
        ZipCodeRange zipCodeRange1 = new ZipCodeRange(from, to);
        ZipCodeRange zipCodeRange2 = new ZipCodeRange(from, to);
        Assert.assertEquals(zipCodeRange1, zipCodeRange2);
    }

    @Test
    public void testHashCode() {
        int from = ZipCodeRange.ZIP_CODE_MIN;
        int to = ZipCodeRange.ZIP_CODE_MAX;
        ZipCodeRange zipCodeRange1 = new ZipCodeRange(from, to);
        ZipCodeRange zipCodeRange2 = new ZipCodeRange(from, to);
        Assert.assertTrue(zipCodeRange1.equals(zipCodeRange2));
        Assert.assertTrue(zipCodeRange1.hashCode() == zipCodeRange2.hashCode());
    }
}
