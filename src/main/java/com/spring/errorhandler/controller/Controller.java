package com.spring.errorhandler.controller;

import com.spring.errorhandler.exception.UserNotfoundException;
import com.spring.errorhandler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author gasieugru
 */
@RestController
@RequestMapping("/users")
public class Controller {

    @Autowired
    private UserService service;

    @GetMapping("/{userId}")
    public void getUser(@PathVariable int userId) {
        service.getUser(userId);
    }

//    @ExceptionHandler({ UserNotfoundException.class })
//    public ResponseEntity<Object> handleException(UserNotfoundException exception) {
//        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
//    }

}
