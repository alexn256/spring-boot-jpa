package com.persistence.repository;

import com.persistence.model.Comment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JPA repository for Comment.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(value = "comment-graph")
    @Query("SELECT c FROM Comment c WHERE c.user.id =:userId")
    List<Comment> findCommentsByUserId(@Param("userId") long userId);

    @EntityGraph(value = "comment-graph")
    Comment findCommentByCommentId(long commentId);

    @EntityGraph(value = "comment-graph")
    @Query("SELECT c FROM Comment c WHERE c.movie.movieId =:movieId")
    List<Comment> findCommentsByMovieId(@Param("movieId") long movieId);

    @EntityGraph(value = "comment-graph")
    List<Comment> findAll();
}
