package com.microservice_first.orderservice.controller;

import com.microservice_first.orderservice.payload.response.UserInfoDto;
import com.microservice_first.orderservice.proxy.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RequestMapping("/order")
@RestController
public class OrderController {

    private final UserServiceProxy proxy;

    @Autowired
    public OrderController(UserServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/ping")
    public String hello(){
        return "pong";
    }

//    @GetMapping("/user-info/{id}")
//    public ResponseEntity<UserInfoDto> getUserInfo(@PathVariable("id") Long userId) {
//
//        /*
//        * hashmap will be used if I have some more path variables and we then bind them in a key-value pair and
//            pass that as a object.
//        *
//        * //HashMap<String, Long> uriVariables = new HashMap<>();
//        * //uriVariables.put("id", userId);
//        */
//
//        ResponseEntity<UserInfoDto> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/user/{id}", UserInfoDto.class, userId);
//        UserInfoDto userInfoDto = responseEntity.getBody();
//
//        return new ResponseEntity<UserInfoDto>(userInfoDto, HttpStatus.OK);
//    }

    @GetMapping("/user-info-feign/{id}")
    public ResponseEntity<UserInfoDto> getUserInfoByFeign(@PathVariable("id") Long userId) {

        UserInfoDto userInfo = proxy.getUserInfo(userId);
        return new ResponseEntity<UserInfoDto>(userInfo, HttpStatus.OK);
    }
    
}
