package com.persistence.repository;

import com.persistence.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void findUserByEmail() {
        final String email = "realspiderman@marvel.com";
        User user = repository.findUserByEmail(email);
        assertNotNull(user);
        assertEquals(email, user.getEmail());
        assertTrue(user.getComments().size() > 0);
    }
}