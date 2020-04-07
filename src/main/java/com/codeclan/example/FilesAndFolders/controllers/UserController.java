package com.codeclan.example.FilesAndFolders.controllers;

import com.codeclan.example.FilesAndFolders.models.User;
import com.codeclan.example.FilesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}