package com.ls.gamePortal.controllers;

import com.ls.gamePortal.models.User;
import com.ls.gamePortal.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    UserService userService = new UserService();
    // User

    // Get all Users
    // Request Type: Get
    // Route: /users
    // Provided data: none
    // Returns: Array of users via JSON

    @GetMapping()
    public List<User> getAll(){
        return userService.retrieveAll();
    }


    // Get one user
    // Request Type: Get
    // Route: /users/:id
    // Provided data: id via path parameter
    // Returns: Single object of user via JSON
    @GetMapping("/{id}")
    public User getOne(@PathVariable("id") int id){
        return userService.retrieveOne(id);
    }


    // Create one user
    // Request Type: Post
    // Route: /users
    // Provided data: User data via body
    // Returns: Created user object
    @PostMapping()
    public User postOne(@RequestBody User user){
        return userService.createOne(user);
    }


    // Update one user
    // Request Type: Put
    // Route: /users/:id
    // Provided data: User data via body
    // Returns: Status code
    @PutMapping("/{id}")
    public void putOne(@PathVariable("id") int id, @RequestBody User user) {
        userService.updateOne(id, user);
    }

    // Delete one user
    // Request Type: Delete
    // Route: /users/:id
    // Provided data: id via path parameter
    // Returns: Status code
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") int id) {
        userService.removeOne(id);
    }

}
