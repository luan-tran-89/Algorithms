package com.practice.streamAPI.exercises.part1.exercises;

import com.practice.streamAPI.exercises.part1.domain.Director;
import com.practice.streamAPI.exercises.part1.domain.Genre;

import java.util.List;

/**
 * @author gasieugru
 */
public record DirectorGenresPair(Director director, List<Genre> genres) {
}
