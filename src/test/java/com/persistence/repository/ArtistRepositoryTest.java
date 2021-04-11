package com.persistence.repository;

import com.persistence.model.Artist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository repository;

    @Test
    void getArtistByIdTest() {
        final long id = 1001;
        Artist artist = repository.findByArtistId(id);
        singleArtistAssert(artist);
    }

    @Test
    void getArtistByLastName() {
        final String lastName = "Reeves";
        Artist artist = repository.findByLastName(lastName);
        singleArtistAssert(artist);
    }

    @Test
    void getAllTest() {
        List<Artist> artists = repository.findAll();
        assertNotNull(artists);
        assertEquals(2, artists.size());
    }

    private void singleArtistAssert(Artist artist) {
        final long artistId = 1001;
        final int moviesSize = 4;

        assertNotNull(artist);
        assertEquals(artistId, artist.getArtistId());
        assertNotNull(artist.getMovies());
        assertEquals(moviesSize, artist.getMovies().size());
    }
}