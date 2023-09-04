package com.microservice_first.userservice.payload.request;

import com.microservice_first.userservice.model.User;
import lombok.Getter;

@Getter
public class AddUserRequest {

    public String username;
    public int age;


    public User convertUser(AddUserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setAge(userRequest.getAge());
        return user;
    }
}
