package com.practice.streamAPI.exercises.part1.exercises;

import com.practice.streamAPI.exercises.part1.domain.Director;
import com.practice.streamAPI.exercises.part1.domain.Genre;
import com.practice.streamAPI.exercises.part1.service.InMemoryMovieService;
import com.practice.streamAPI.exercises.part1.service.MovieService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q.3) Find the number of genres of each director's movies
 *
 * Output:
 * Marc Webb
 * 	Drama: 1
 * 	Comedy: 1
 * 	Romance: 1
 * Peter Hyams
 * 	Mystery: 1
 * 	Drama: 1
 * Mark Neveldine
 * 	Action: 1
 * 	Thriller: 1
 * 	Sci-Fi: 1
 * Brian Taylor
 * 	Action: 1
 * 	Thriller: 1
 * 	Sci-Fi: 1
 *
 * @author gasieugru
 */
public class Exercises3 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        var movies = movieService.findAllMovies();

        var res = movies.stream()
                .flatMap(movie -> movie.getDirectors().stream()
                        .map(dir -> new DirectorGenresPair(dir, movie.getGenres())))
                .flatMap(dirGen -> dirGen.genres().stream()
                        .map(genre -> new DirectorGenrePair(dirGen.director(), genre)))
                .collect(Collectors.groupingBy(
                        DirectorGenrePair::director,
                        Collectors.groupingBy(DirectorGenrePair::genre, Collectors.counting())));

        res.forEach((dir, genCounts) -> {
            System.out.println(dir.getName());
            genCounts.forEach((gen, count) -> System.out.printf("\t%s: %s\n", gen.getName(), count));
        });

//        Exercises3.getNumberOfGenresEachDirector();
    }

    private static void getNumberOfGenresEachDirector() {
        // Find the number of genres of each director's movies
        var directorGenreNumbers =
                movieService.findAllMovies()
                        .stream()
                        .map( movie -> movie.getDirectors().stream().map(director -> new DirectorGenresPair(director,movie.getGenres())).toList())
                        .flatMap(Collection::stream)
                        .map( directorGenres -> directorGenres.genres().stream().map( genre -> new DirectorGenrePair(directorGenres.director(),genre) ).toList())
                        .flatMap(Collection::stream)
                        .collect(Collectors.groupingBy(DirectorGenrePair::director,Collectors.groupingBy(DirectorGenrePair::genre,Collectors.counting())));
        directorGenreNumbers.forEach((director,genreCounts)->{
            System.out.printf("%s\n",director.getName());
            genreCounts.forEach( (genre,count) -> System.out.printf("\t%s: %s\n",genre.getName(),count));
        });
    }

    public record DirectorGenresPair(Director director, List<Genre> genres) {

    }

    public record DirectorGenrePair(Director director, Genre genre) {

    }
}
