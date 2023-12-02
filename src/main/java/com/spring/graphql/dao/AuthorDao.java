package com.spring.graphql.dao;

import com.spring.graphql.entity.Author;

import java.util.List;

/**
 * @author gasieugru
 */
public class AuthorDao {
    private final List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    public Author getAuthor(String id) {
        return authors.stream()
                .filter(author -> id.equals(author.getId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
