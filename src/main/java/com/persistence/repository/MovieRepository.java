package com.persistence.repository;

import com.persistence.model.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JPA repository for Movie.
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @EntityGraph(value = "movie-graph")
    Movie findByTitle(String title);

    @EntityGraph(value = "movie-graph")
    Movie findByMovieId(Long id);

    @EntityGraph(value = "movie-graph")
    List<Movie> findMoviesByYear(int year);

    @EntityGraph(value = "movie-graph")
    List<Movie> findAll();

    @EntityGraph(value = "movie-graph")
    @Query("select m from Movie m where m.imdb.id =:imdbId")
    Movie findMovieByImdbId(@Param("imdbId") long imdbId);
}
