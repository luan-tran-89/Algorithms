package com.practice.streamAPI.exercises.part1.exercises;

import com.practice.streamAPI.exercises.part1.dao.CityDao;
import com.practice.streamAPI.exercises.part1.dao.CountryDao;
import com.practice.streamAPI.exercises.part1.dao.InMemoryWorldDao;
import com.practice.streamAPI.exercises.part1.domain.City;
import com.practice.streamAPI.exercises.part1.domain.Country;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Q.4) Find the highest populated capital city
 *
 * Output:
 *  City [id=2331, name=Seoul, population=9981619, countryCode=KOR]
 *
 * @author gasieugru
 */
public class Exercises4 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
    private static final CityDao cityDao = InMemoryWorldDao.getInstance();

    public static void main(String[] args) {
        var countries = countryDao.findAllCountries();

        var res = countries.stream()
                .flatMap(country -> country.getCities().stream()
                        .filter(city -> city.getId() == country.getCapital()))
                .max(Comparator.comparing(City::getPopulation));
//                .collect(Collectors.maxBy((c1, c2) -> c1.getPopulation() - c2.getPopulation()));

        res.ifPresent(System.out::println);

        Exercises4.getHighestPopulatedCapitalCity();
    }

    /**
     * Find the highest populated capital city based on the github example
     * @return highest populated capital city
     */
    private static Optional<City> getHighestPopulatedCapitalCity() {
        // Find the highest populated capital city
        var highPopulatedCapitalCity =
                countryDao.findAllCountries()
                        .stream()
                        .map(Country::getCapital)
                        .filter(Objects::nonNull)
                        .map(cityDao::findCityById)
                        .filter(Objects::nonNull)
                        .max(Comparator.comparing(City::getPopulation));
        highPopulatedCapitalCity.ifPresent(System.out::println);
        return highPopulatedCapitalCity;
    }

}
