package com.microservice_first.userservice.service;

import com.microservice_first.userservice.model.User;
import com.microservice_first.userservice.payload.request.AddUserRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<User> addUser(AddUserRequest userRequest);

    ResponseEntity<User> getUser(Long userId);
}
