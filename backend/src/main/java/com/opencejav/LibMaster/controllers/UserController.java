package com.opencejav.LibMaster.controllers;

import com.opencejav.LibMaster.models.User;
import com.opencejav.LibMaster.repository.UserRepository;
import com.opencejav.LibMaster.utils.ResponseContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("user/welcome")
    public ResponseEntity<?> welcome() {
        return ResponseEntity.ok(new ResponseContent("Welcome!", "RESPONSE_TYPE: INFO"));
    }

    @GetMapping("user")
    public ResponseEntity<?> find(@RequestBody String username) {
        userRepository.findAll();
        return ResponseEntity.ok(new ResponseContent("Success!", "RESPONSE_TYPE: CONFIRMATION"));
    }

    // TODO: Implement ResponseEntity<?>
    @PutMapping("user")
    public Object update(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(new ResponseContent("Updated successfully!", "RESPONSE_TYPE: CONFIRMATION"));
    }

    // TODO: Implement ResponseEntity<?>
    @PostMapping("user")
    public Object create(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(new ResponseContent("Success!", "RESPONSE_TYPE: CONFIRMATION"));
    }

    // TODO: Implement ResponseEntity<?>
    @DeleteMapping("user")
    public Object delete(@RequestBody User user) {
        userRepository.delete(user);
        return ResponseEntity.ok(new ResponseContent("Deleted successfully!", "RESPONSE_TYPE: CONFIRMATION"));
    }
}