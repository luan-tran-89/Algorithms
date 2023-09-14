package com.practice.streamAPI.exercises.part1.exercises;

import com.practice.streamAPI.exercises.part1.domain.City;

import java.util.Optional;

/**
 * @author gasieugru
 */
public record ContinentCityPair(String continent, City city) implements Comparable<ContinentCityPair> {

    @Override
    public int compareTo(ContinentCityPair o) {
        return this.city.getPopulation() - o.city.getPopulation();
    }

    public static void printEntry(String continent, Optional<ContinentCityPair> pair) {
        System.out.printf("%s: %s\n", continent, pair.get().city());
    }
}
