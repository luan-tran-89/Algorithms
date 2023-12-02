package com.spring.errorhandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * https://www.tutorialspoint.com/spring_boot/spring_boot_exception_handling.htm
 *
 * @author gasieugru
 */

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler({ UserNotfoundException.class })
    public ResponseEntity handleException(UserNotfoundException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
