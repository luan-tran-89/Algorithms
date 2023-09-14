package com.practice.streamAPI.exercises.part1.exercises;

import com.practice.streamAPI.exercises.part1.dao.CountryDao;
import com.practice.streamAPI.exercises.part1.dao.InMemoryWorldDao;
import com.practice.streamAPI.exercises.part1.domain.City;
import com.practice.streamAPI.exercises.part1.domain.Country;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Q.1) Find the most populated city of each continent
 *
 * Output:
 * South America: City [id=206, name=SÃ†o Paulo, population=9968485, countryCode=BRA]
 * Asia: City [id=1024, name=Mumbai (Bombay), population=10500000, countryCode=IND]
 * Europe: City [id=3580, name=Moscow, population=8389200, countryCode=RUS]
 * Africa: City [id=608, name=Cairo, population=6789479, countryCode=EGY]
 * North America: City [id=2515, name=Ciudad de Mâ€šxico, population=8591309, countryCode=MEX]
 * Oceania: City [id=130, name=Sydney, population=3276207, countryCode=AUS]
 *
 * @author gasieugru
 */
public class Exercises1 {
    private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

    private static Comparator<City> comparator = Comparator.comparingInt(City::getPopulation);

    public static void main(String[] args) {
        System.out.println("Using normal streamAPI");
        Exercises1.getPopulatedCityEachContinent();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println("Using streamAPI with the ContinentCityPair");
        Exercises1.getPopulatedCityEachContinent1();
    }

    /**
     * Using normal streamAPI
     * @return Populated City for Each Continent
     */
    public static Map<String, City> getPopulatedCityEachContinent() {
        List<Country> countries = countryDao.findAllCountries();

        var res = countries.stream()
                .filter(country -> country.getCities() != null && !country.getCities().isEmpty())
                .collect(Collectors.toMap(
                        Country::getContinent,
                        country -> country.getCities().stream()
                                .collect(Collectors.maxBy(comparator)).get(),
                        (c1, c2) -> comparator.compare(c1, c2) > 0 ? c1 : c2,
                        TreeMap::new));
        res.entrySet().forEach(c -> System.out.printf("%s: %s\n", c.getKey(), c.getValue()));
        return res;
    }

    /**
     * Using streamAPI with the ContinentCityPair
     * @return Populated City for Each Continent
     */
    public static Map<String, Optional<ContinentCityPair>> getPopulatedCityEachContinent1() {
        List<Country> countries = countryDao.findAllCountries();

        var res = countries.stream()
                .flatMap(country -> country.getCities().stream()
                        .map(city -> new ContinentCityPair(country.getContinent(), city)))
                .collect(Collectors.groupingBy(ContinentCityPair::continent, TreeMap::new, Collectors.maxBy(ContinentCityPair::compareTo)));

        res.forEach(ContinentCityPair::printEntry);
        return res;
    }

}
