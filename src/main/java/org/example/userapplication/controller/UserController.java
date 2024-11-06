package org.example.userapplication.controller;

import org.example.userapplication.dto.UserDTO;
import org.example.userapplication.model.User;
import org.example.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO data) {
        return new ResponseEntity<>(this.userService.createUser(data), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.findUserById(id), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> editUser(@PathVariable Integer id, @RequestBody UserDTO data) {
        return new ResponseEntity<>(this.userService.editUser(id, data), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.deleteUser(id), HttpStatus.OK);
    }
}
