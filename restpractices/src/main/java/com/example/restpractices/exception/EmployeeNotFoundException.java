package com.example.restpractices.exception;

import java.time.LocalDateTime;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
    
}
