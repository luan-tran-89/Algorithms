package com.spring.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gasieugru
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private String id;
    private String name;
    private String thumbnail;
}
