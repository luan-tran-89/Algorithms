package com.interview.kforce.sample.wsi.service;

import com.interview.kforce.sample.wsi.model.ZipCodeRange;

import java.util.List;

/**
 * ZipCodeService is a service that handles some operations related to Zip Code such as merging overlap Zip Code Ranges
 *
 * @author Luan Tran
 */
public interface ZipCodeService {

    /**
     * Merge overlap Zip Code Ranges.
     *
     * @param zipCodeRanges Zip Code ranges as 2D array
     * @return the merge list of Zip Code ranges
     */
    List<ZipCodeRange> mergedZipCodeRanges(int[][] zipCodeRanges);

}
