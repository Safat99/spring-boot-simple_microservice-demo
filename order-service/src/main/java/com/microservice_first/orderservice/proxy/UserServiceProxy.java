package com.microservice_first.orderservice.proxy;

import com.microservice_first.orderservice.payload.response.UserInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url="localhost:8080")
public interface UserServiceProxy {

    @GetMapping("/user/{id}")
    public UserInfoDto getUserInfo(@PathVariable("id") Long userId);
}
