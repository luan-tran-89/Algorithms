package com.practice.streamAPI.exercises.part1.exercises;

import com.practice.streamAPI.exercises.part1.dao.CountryDao;
import com.practice.streamAPI.exercises.part1.dao.InMemoryWorldDao;

/**
 * Q.5) Find the highest populated capital city of each continent
 *
 * Output:
 *
 *
 * @author gasieugru
 */
public class Exercises5 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        var countries = countryDao.findAllCountries();

        var res = countries.stream();


    }

}
