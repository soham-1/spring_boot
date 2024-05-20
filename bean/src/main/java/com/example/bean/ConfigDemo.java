package com.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDemo {

    @Bean
    public String sayHello() {
        return "Hello";
    }
}
