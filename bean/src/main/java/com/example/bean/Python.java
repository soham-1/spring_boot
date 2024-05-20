package com.example.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Python implements Language {

    @Override
    public String greet() {
        return "This is Python Language";
    }
}
