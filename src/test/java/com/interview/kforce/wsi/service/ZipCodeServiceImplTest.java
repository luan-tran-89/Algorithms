package com.interview.kforce.wsi.service;

import com.interview.kforce.sample.wsi.model.ZipCodeRange;
import com.interview.kforce.sample.wsi.service.ZipCodeService;
import com.interview.kforce.sample.wsi.service.impl.ZipCodeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author gasieugru
 */
public class ZipCodeServiceImplTest {
    private ZipCodeService zipCodeService;

    @Before
    public void setUp() {
        zipCodeService = new ZipCodeServiceImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergedZipCodesRanges_WithNull() {
        zipCodeService.mergedZipCodeRanges(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergedZipCodesRanges_MissingRange() {
        int[][] zipCodesRanges = {{94133, 94133}, {94299}};
        zipCodeService.mergedZipCodeRanges(zipCodesRanges);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMergedZipCodesRanges_FromGreaterThanTo() {
        int[][] zipCodesRanges = {{94233, 94133}};
        zipCodeService.mergedZipCodeRanges(zipCodesRanges);
    }

    @Test
    public void testMergedZipCodesRanges_NoOverlap() {
        int[][] zipCodesRanges = {{94133, 94133}, {94133, 94133}, {94133, 94133}, {94200, 94299}, {94600, 94699}};
        int[][] expectedRanges = {{94133, 94133}, {94200, 94299}, {94600, 94699}};

        List<ZipCodeRange> results = zipCodeService.mergedZipCodeRanges(zipCodesRanges);
        List<ZipCodeRange> expected = this.parseZipCodesRange(expectedRanges);
        results.sort(zipCodeRangeComparator());
        expected.sort(zipCodeRangeComparator());

        assertEquals(expected, results);
    }

    @Test
    public void testMergedZipCodesRanges_Overlap() {
        int[][] zipCodesRanges = {{94133, 94133}, {94200,94299}, {94226,94399}};
        int[][] expectedRanges = {{94133, 94133}, {94200,94399}};

        List<ZipCodeRange> results = zipCodeService.mergedZipCodeRanges(zipCodesRanges);
        List<ZipCodeRange> expected = this.parseZipCodesRange(expectedRanges);
        results.sort(zipCodeRangeComparator());
        expected.sort(zipCodeRangeComparator());

        assertEquals(expected, results);
    }

    private List<ZipCodeRange> parseZipCodesRange(int[][] zipCodeRanges) {
        return Stream.of(zipCodeRanges)
                .map(zip -> new ZipCodeRange(zip[0], zip[1]))
                .sorted(zipCodeRangeComparator())
                .collect(Collectors.toList());
    }

    private Comparator<ZipCodeRange> zipCodeRangeComparator() {
        return Comparator.comparingInt(ZipCodeRange::getFrom);
    }
}
