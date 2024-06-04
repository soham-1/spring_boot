package com.example.advice;

import org.springframework.stereotype.Component;

@Component
public class Run {

    public void addJog() {
        System.out.println("jogging starts");
    }

    public void addSprint() {
        System.out.println("Sprint starts");
    }
}
