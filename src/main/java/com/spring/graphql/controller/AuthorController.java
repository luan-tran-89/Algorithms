package com.spring.graphql.controller;

import com.spring.graphql.dao.PostDao;
import com.spring.graphql.entity.Author;
import com.spring.graphql.entity.Post;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author gasieugru
 */
@Controller
public class AuthorController {

    private final PostDao postDao;

    public AuthorController(PostDao postDao) {
        this.postDao = postDao;
    }

    @SchemaMapping
    public List<Post> posts(Author author) {
        return postDao.getAuthorPosts(author.getId());
    }

}
