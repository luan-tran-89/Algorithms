package com.practice.streamAPI.exercises.part1.dao;

import com.practice.streamAPI.exercises.part1.domain.City;

import java.util.List;

/**
 * @author gasieugru
 */
public interface CityDao {
    City findCityById(int id);

    City removeCity(City city);

    City addCity(City city);

    City updateCity(City city);

    List<City> findAllCities();

    List<City> findCitiesByCountryCode(String countryCode);
}
