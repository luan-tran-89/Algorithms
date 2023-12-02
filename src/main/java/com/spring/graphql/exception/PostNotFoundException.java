package com.spring.graphql.exception;

/**
 * @author gasieugru
 */
public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String message) {
        super(message);
    }
}
