package com.spring.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author gasieugru
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private String id;
    private String title;
    private String text;
    private String category;
    private String authorId;

    public Post(String title, String text, String category, String authorId) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.authorId = authorId;
    }
}
