package com.example.exceptiondemo;

public class StudentException extends RuntimeException {
    public StudentException(String message) {
        super(message);
    }
}
