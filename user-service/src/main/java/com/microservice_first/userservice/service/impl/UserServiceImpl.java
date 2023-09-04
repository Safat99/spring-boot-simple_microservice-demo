package com.microservice_first.userservice.service.impl;

import com.microservice_first.userservice.exception.BadRequestException;
import com.microservice_first.userservice.exception.ResourceNotFoundException;
import com.microservice_first.userservice.model.User;
import com.microservice_first.userservice.payload.request.AddUserRequest;
import com.microservice_first.userservice.repository.UserRepository;
import com.microservice_first.userservice.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<User> addUser(AddUserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new BadRequestException("this username is already taken!!!");
        }
        User user = userRequest.convertUser(userRequest);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User user1 = user.get();
            return new ResponseEntity<>(user1, HttpStatus.ACCEPTED);
        }
        throw new ResourceNotFoundException("no user found against this userId!!");
    }
}
