package com.persistence.repository;

import com.persistence.model.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Test
    void findCommentByUserId() {
        final long userId = 1004;
        final int commentsCount = 3;
        List<Comment> comments = repository.findCommentsByUserId(userId);
        assertEquals(commentsCount, comments.size());
        comments.forEach(comment -> checkCommentAttachment(comment, 0, 0, userId));
    }

    @Test
    void findCommentByCommentId() {
        final long commentId = 1001;
        Comment comment = repository.findCommentByCommentId(commentId);
        checkCommentAttachment(comment, commentId, 0, 0);
    }

    @Test
    void findCommentByMovieId() {
        final long movieId = 301;
        final int commentsCount = 3;
        List<Comment> comments = repository.findCommentsByMovieId(movieId);
        assertNotNull(comments);
        assertEquals(commentsCount, comments.size());
        comments.forEach(comment -> checkCommentAttachment(comment, 0, movieId, 0));
    }

    @Test
    void findAllCommentsTest() {
        final int commentsCount = 5;
        List<Comment> comments = repository.findAll();
        assertNotNull(comments);
        assertEquals(commentsCount, comments.size());
    }

    private void checkCommentAttachment(Comment comment, long commentId, long movieId, long userId) {
        assertNotNull(comment);
        if (commentId != 0) {
            assertEquals(commentId, comment.getCommentId());
        } else {
            assertTrue(comment.getCommentId() > 0);
        }
        assertNotNull(comment.getMovie());
        if (movieId != 0) {
            assertEquals(movieId, comment.getMovie().getMovieId());
        }
        assertNotNull(comment.getUser());
        if (userId > 0) {
            assertEquals(userId, comment.getUser().getId());
        }
    }

}