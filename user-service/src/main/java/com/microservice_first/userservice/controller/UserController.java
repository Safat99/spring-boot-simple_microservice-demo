package com.microservice_first.userservice.controller;

import com.microservice_first.userservice.configuration.Configuration;
import com.microservice_first.userservice.model.User;
import com.microservice_first.userservice.payload.request.AddUserRequest;
import com.microservice_first.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final Configuration configuration;

    @Autowired
    public UserController(UserService userService, Configuration configuration) {
        this.userService = userService;
        this.configuration = configuration;
    }

    @GetMapping("/hello")
    ResponseEntity<String> helloController() {
        return new ResponseEntity<>("hello there", HttpStatus.OK);
    }

    @GetMapping("/configuration")
    ResponseEntity<Configuration> seeConfiguration() {
        return new ResponseEntity<>(configuration, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<User> addUser(@RequestBody AddUserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUser(@PathVariable("id") Long userId) {
        return userService.getUser(userId);
    }

}