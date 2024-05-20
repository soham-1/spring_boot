package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class FieldInjection implements Language {

    @Override
    public String greet() {
        return "This is Field Injection";
    }

}
