package com.opencejav.LibMaster.controllers;

import com.opencejav.LibMaster.models.User;
import com.opencejav.LibMaster.repository.UserRepository;
import com.opencejav.LibMaster.utils.ResponseContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private Optional<User> optionalUser; // Dummy Optional

    @GetMapping("user/welcome")
    public ResponseEntity<?> baseRoute() {
        return  ResponseEntity
                .ok()
                .body(new ResponseContent("Welcome!", "RESPONSE_TYPE: WELCOME_MESSAGE"));
    }

    @GetMapping("user")
    public ResponseEntity<?> findAllUsers(@RequestBody String username) {
        return ResponseEntity
                .ok()
                .body(userRepository.findAll());
    }

    // TODO: Implement ResponseEntity<?>
    @PutMapping("user")
    public Object updateUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(new ResponseContent("Updated successfully!", "RESPONSE_TYPE: CONFIRMATION"));
    }

    // TODO: Implement ResponseEntity<?>
    @PostMapping("user")
    public Object createUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(new ResponseContent("Success!", "RESPONSE_TYPE: CONFIRMATION"));
    }

    // TODO: Implement ResponseEntity<?>
    @DeleteMapping("user")
    public Object deleteUser(@RequestBody User user) {
        userRepository.delete(user);
        return ResponseEntity.ok(new ResponseContent("Deleted successfully!", "RESPONSE_TYPE: CONFIRMATION"));
    }
}