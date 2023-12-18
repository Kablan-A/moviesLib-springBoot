package com.kablan.movieslib.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "https://movies-lib-project.netlify.app/")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/{eMail}")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String eMail) {
        return new ResponseEntity<Optional<User>>(userService.singleUser(eMail), HttpStatus.OK);
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        // Use the template to add data
        mongoTemplate.save(user, "users");
        return "Added successfully";
    }
}
