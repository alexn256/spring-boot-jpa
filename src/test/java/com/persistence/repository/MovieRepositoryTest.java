package com.persistence.repository;

import com.persistence.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ActiveProfiles("test")
class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;

    @Test
    void findByIdTest() {
        final String title = "The Matrix";
        Movie movie = repository.findByTitle(title);
        singleMovieAssert(movie);
    }

    @Test
    void findByMovieIdTest() {
        final long movieId = 301;
        Movie movie = repository.findByMovieId(movieId);
        singleMovieAssert(movie);
    }

    @Test
    void findByMovieYearTest() {
        final int year = 2003;
        List<Movie> movies = repository.findMoviesByYear(year);
        assertNotNull(movies);
        assertEquals(2, movies.size());
        movies.stream().map(movie -> movie.getYear()).forEach(y -> assertEquals(year, y));
    }

    @Test
    void findAllTest() {
        final int moviesSize = 4;
        List<Movie> movies = repository.findAll();
        assertNotNull(movies);
        assertEquals(moviesSize, movies.size());
    }

    @Test
    void findMovieByImdbIdTest() {
        final long imdbId = 133093;
        Movie movie = repository.findMovieByImdbId(imdbId);
        assertEquals(imdbId, movie.getImdb().getId());
        singleMovieAssert(movie);
    }

    private void singleMovieAssert(Movie movie) {
        final long movieId = 301;
        final int castSize = 2;
        final String title = "The Matrix";

        assertNotNull(movie);
        assertEquals(title, movie.getTitle());
        assertEquals(movieId, movie.getMovieId());
        assertNotNull(movie.getCast());
        assertEquals(castSize, movie.getCast().size());
        assertNotNull(movie.getCountries());
        assertNotNull(movie.getImdb());
    }

}