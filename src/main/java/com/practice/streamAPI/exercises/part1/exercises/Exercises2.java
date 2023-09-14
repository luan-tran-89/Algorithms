package com.practice.streamAPI.exercises.part1.exercises;

import com.practice.streamAPI.exercises.part1.domain.Director;
import com.practice.streamAPI.exercises.part1.domain.Movie;
import com.practice.streamAPI.exercises.part1.service.InMemoryMovieService;
import com.practice.streamAPI.exercises.part1.service.MovieService;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Q.2) Find the number of movies of each director
 *
 * Output:
 * Sam Taylor Wood:   1
 *         F. Gary Gray:   1
 *  Oliver Hirschbiegel:   1
 *         Scott Cooper:   1
 *  Katherine Dieckmann:   1
 *      Kevin Macdonald:   1
 *        Peter Jackson:   2
 *  ...
 *  ...
 *
 * @author gasieugru
 */
public class Exercises2 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        var movies = movieService.findAllMovies();

        var res = movies.stream()
                .flatMap(movie -> movie.getDirectors().stream())
                .collect(Collectors.groupingBy(Director::getName, Collectors.counting()));

        res.forEach((name, count) -> System.out.printf("%25s: %s\n", name, count));
    }


    private static Map<String,Long> getNumberOfMoviesEachDirector() {
        var movies = movieService.findAllMovies();
        Map<String,Long> dirMovCounts =
                movies.stream().map(Movie::getDirectors)
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(
                                        Director::getName,
                                        Collectors.counting()
                                )
                        );
        dirMovCounts.forEach(
                (name,count) -> System.out.printf("%20s: %3d\n",name,count)
        );

        return dirMovCounts;
    }
}
