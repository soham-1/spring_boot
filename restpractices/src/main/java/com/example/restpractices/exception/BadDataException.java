package com.example.restpractices.exception;

import org.springframework.http.HttpStatus;

public class BadDataException extends RuntimeException{

    private String message;

    public BadDataException(String message) {
        super(message);
    }
}
