package com.interview.sevenEleven.springRest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gasieugru
 */
@Component
public class DatabaseHelper implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        //...
    }

    public void addKnife(Knife knife) {
        //...
        System.out.println(knife);
    }

    public List<User> getUsers() {
        User user = new User(1, "John");
        User user1 = new User(2, "Thomas");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        return users;
    }

    public String convertToJsonString(List<User> users) {
        // Blank 1: Using Jackson object mapper,
        // write the users list value to the output stream
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
