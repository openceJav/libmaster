package com.opencejav.LibMaster.controllers;

import com.opencejav.LibMaster.models.User;
import com.opencejav.LibMaster.repositories.UserRepository;
import com.opencejav.LibMaster.tools.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping("user/welcome")
    public Object welcome() {
        return new Response("Welcome!", "Welcome!");
    }

    @GetMapping("user")
    public Object find(@RequestBody String username) {
        System.out.println(repo.findById(username));
        return new Response("Success!", "Confirmation");
    }

    @PutMapping("user")
    public Object update(@RequestBody User user) {
        System.out.println(repo.save(user));
        return new Response("Success!", "Confirmation");
    }

    @PostMapping("user")
    public Object create(@RequestBody User user) {
        System.out.println(repo.save(user));
        return new Response("Success!", "Confirmation");
    }

    @DeleteMapping("user")
    public Object delete(@RequestBody User user) {
        repo.delete(user);
        return new Response("Deleted successfully!", "Confirmation.");
    }
}