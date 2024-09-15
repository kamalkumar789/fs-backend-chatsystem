package com.chatsystem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatsystem.dtos.Auth.UsersSignupDTO;
import com.chatsystem.services.UsersServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Validated
public class UsersController {

    @Autowired
    private UsersServices usersServices;

    @PostMapping("/createuser")
    public ResponseEntity<String> addUser(@Valid @RequestBody UsersSignupDTO user) {
        
        try {
            usersServices.saveUserDetails(user);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully done");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
