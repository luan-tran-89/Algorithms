package com.spring.graphql.dao;

import com.spring.graphql.entity.Post;
import com.spring.graphql.exception.PostNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class PostDao {

    private final List<Post> posts;


    public PostDao(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream()
                .skip(offset)
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Post> getAuthorPosts(String author) {
        List<Post> res =  posts.stream()
                .filter(post -> author.equals(post.getAuthorId()))
                .collect(Collectors.toList());

        if (res.isEmpty()) {
            throw new PostNotFoundException("There is no post with author " + author);
        }

        return res;
    }

    public void savePost(Post post) {
        posts.add(post);
    }

}
