package com.interview.sevenEleven.springRest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gasieugru
 */
@RestController
@RequestMapping("/API/users")
public class UserController {

    @Autowired
    private DatabaseHelper helper;

    @GetMapping
    public ResponseEntity<String> getUsers() {
        List<User> users;
        // Blank 4:
        users = helper.getUsers();
        String jsonList;
        // BLank 5:
        jsonList = helper.convertToJsonString(users);

        if (jsonList != null) {
            return ResponseEntity.ok(jsonList);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

}
