package com.spring.errorhandler.service;

import com.spring.errorhandler.exception.UserNotfoundException;
import org.springframework.stereotype.Service;

/**
 * @author gasieugru
 */
@Service
public class UserService {

    public Object getUser(int userId) {
        throw new UserNotfoundException("User is not found: " + userId);
    }

}
