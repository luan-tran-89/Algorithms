package com.interview.kforce.sample.wsi.service.impl;

import com.interview.kforce.sample.wsi.model.ZipCodeRange;
import com.interview.kforce.sample.wsi.service.ZipCodeService;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ZipCodeServiceImpl is a service implementation of {@link ZipCodeService} that handles some operations related to Zip Code such as merging overlap Zip Code Ranges
 *
 * @author Luan Tran
 */
public class ZipCodeServiceImpl implements ZipCodeService {
    public static final String ZIP_CODE_RANGE_REQUIRED_TWO_NUMBERS = "Zip Code Range requires two numbers.";

    /**
     * Merge overlap Zip Code Ranges.
     * {@link ZipCodeService#mergedZipCodeRanges(int[][])}
     *
     * @param zipCodeRanges Zip Code ranges as 2D array
     * @return the merge list of Zip Code ranges
     */
    @Override
    public List<ZipCodeRange> mergedZipCodeRanges(int[][] zipCodeRanges) {
        Deque<ZipCodeRange> result = new ArrayDeque<>();

        this.convertZipCodeRanges(zipCodeRanges)
            .stream()
            .sorted(Comparator.comparing(ZipCodeRange::getFrom))
            .forEach(currentZipCode -> {
                if (result.isEmpty()) {
                    result.add(currentZipCode);
                } else {
                    ZipCodeRange zipCodeRange = result.peekFirst();

                    // if no overlap
                    if (currentZipCode.getFrom() > zipCodeRange.getTo()) {
                        result.addFirst(currentZipCode);
                    } else if (currentZipCode.getFrom() < zipCodeRange.getTo()) {
                        // Merged overlap zip code range
                        ZipCodeRange mergedZipCodeRange = new ZipCodeRange(zipCodeRange.getFrom(), currentZipCode.getTo());
                        result.pollFirst();
                        result.addFirst(mergedZipCodeRange);
                    }
                }
            });

        return result.stream().collect(Collectors.toList());
    }

    private List<ZipCodeRange> convertZipCodeRanges(int[][] zipCodeRanges) {
        if (zipCodeRanges == null) {
            throw new IllegalArgumentException();
        }

        return Stream.of(zipCodeRanges)
                .map((zipCode) -> {
                    if (zipCode.length != 2) {
                        throw new IllegalArgumentException(ZIP_CODE_RANGE_REQUIRED_TWO_NUMBERS);
                    }
                    return new ZipCodeRange(zipCode[0], zipCode[1]);
                }).toList();
    }
}
