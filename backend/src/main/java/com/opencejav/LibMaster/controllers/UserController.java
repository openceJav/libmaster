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
    private UserRepository repo;

    @GetMapping("user/welcome")
    public ResponseEntity<?> welcome() {
        return ResponseEntity.ok(new ResponseContent("Welcome!", "RESPONSE_TYPE: INFO"));
    }

    @GetMapping("user")
    public ResponseEntity<?> find(@RequestBody String username) {
        System.out.println(repo.findById(username));
        return ResponseEntity.ok(new ResponseContent("Success!", "Confirmation"));
    }

    // TODO: Implement ResponseEntity<?>
    @PutMapping("user")
    public Object update(@RequestBody User user) {
        System.out.println(repo.save(user));
        return new ResponseContent("Success!", "Confirmation");
    }

    // TODO: Implement ResponseEntity<?>
    @PostMapping("user")
    public Object create(@RequestBody User user) {
        System.out.println(repo.save(user));
        return new ResponseContent("Success!", "Confirmation");
    }

    // TODO: Implement ResponseEntity<?>
    @DeleteMapping("user")
    public Object delete(@RequestBody User user) {
        repo.delete(user);
        return new ResponseContent("Deleted successfully!", "Confirmation.");
    }
}