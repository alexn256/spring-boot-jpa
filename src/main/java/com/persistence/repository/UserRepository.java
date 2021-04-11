package com.persistence.repository;

import com.persistence.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for User.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    @EntityGraph(value = "user-graph")
    User findUserByEmail(String email);
}
