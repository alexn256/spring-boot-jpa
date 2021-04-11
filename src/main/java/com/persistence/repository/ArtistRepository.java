package com.persistence.repository;

import com.persistence.model.Artist;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * JPA repository for Artist.
 */
public interface ArtistRepository extends JpaRepository<Artist, Long> {

        @EntityGraph(value = "artist-graph")
        Artist findByLastName(String title);

        @EntityGraph(value = "artist-graph")
        Artist findByArtistId(Long id);

        @EntityGraph(value = "artist-graph")
        List<Artist> findAll();
}
