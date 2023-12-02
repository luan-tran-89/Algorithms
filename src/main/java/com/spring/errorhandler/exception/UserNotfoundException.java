package com.spring.errorhandler.exception;

/**
 * @author gasieugru
 */
public class UserNotfoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserNotfoundException() {
        super();
    }

    public UserNotfoundException(String message) {
        super(message);
    }
}
