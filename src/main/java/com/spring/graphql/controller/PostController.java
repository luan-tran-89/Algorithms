package com.spring.graphql.controller;

import com.spring.graphql.dao.AuthorDao;
import com.spring.graphql.dao.PostDao;
import com.spring.graphql.entity.Author;
import com.spring.graphql.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author gasieugru
 */
@Controller
//@RequestMapping("/post")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostDao postDao;
    private final AuthorDao authorDao;

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
        return postDao.getRecentPosts(count, offset);
    }

    @QueryMapping
    public List<Post> searchByAuthor(@Argument String authorId) {
        return postDao.getAuthorPosts(authorId);
    }

    @SchemaMapping
    public Author author(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }

    @SchemaMapping(typeName = "Post", field = "first_author")
    public Author getFirstAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }

    @MutationMapping
    public Post createPost(@Argument String title, @Argument String text,
                           @Argument String category, @Argument String authorId) {
        Post post = new Post(title, text, category, authorId);
        post.setId(UUID.randomUUID().toString());

        postDao.savePost(post);
        return post;
    }
}
