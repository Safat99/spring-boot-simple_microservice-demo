package com.microservice_first.userservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Getter
@Setter
@ConfigurationProperties("user-service")
@Component
public class Configuration {
    private String admin;
    private int number;
}
