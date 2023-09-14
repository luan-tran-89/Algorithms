package com.interview.sevenEleven.springRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gasieugru
 */
// Blank 1: Use thecorrect annotation to make this class REST Controller.
@RestController
//@RequestMapping("/API")
public class KnifeController {

    // Blank 2: Create a helper field fo class as an autowired instance of DatabaseHelper.
    @Autowired
    private DatabaseHelper dbHelper;

    // Blank 3: Use the correct annotation to map the method to the correct API request
    // Set the correct name and method type for this request (see the table in the description)
    @PostMapping("API/addKnife")
    public ResponseEntity<String> addKnife(@RequestBody Knife knife) {
        // Blank 4:  Use the helper field you added ni Blank 2 to add the knife model to the database
        // Call the corresponding method of the DatabaseHelper class.
        dbHelper.addKnife(knife);

        // Blank 5: Set the entity variable to Response Entity having the status OK.
        ResponseEntity<String> entity = ResponseEntity.status(HttpStatus.OK).body("200 - OK");
//        ResponseEntity<String> entity = ResponseEntity.ok().body("200 - OK");
//        ResponseEntity<String> entity1 = new ResponseEntity<>("200 - OK", HttpStatus.OK);
        ResponseEntity<String> entity2 = ResponseEntity.ok("200 - OK");
        return entity;
    }

}
