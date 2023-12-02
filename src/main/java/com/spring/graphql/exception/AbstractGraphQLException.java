package com.spring.graphql.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gasieugru
 */
public class AbstractGraphQLException extends RuntimeException {

    private Map<String, Object> parameters = new HashMap<>();

    public AbstractGraphQLException(String message) {
        super(message);
    }

    public AbstractGraphQLException(String message, Map<String, Object> parameters) {
        this(message);
        if (parameters != null) {
            this.parameters = parameters;
        }
    }

    public Map<String, Object> getExtensions() {
        return parameters.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
