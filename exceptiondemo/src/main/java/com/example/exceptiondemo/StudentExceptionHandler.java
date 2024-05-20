package com.example.exceptiondemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentExceptionResponse> handleStudentException(StudentException studentException) {
        StudentExceptionResponse studentExceptionResponse = new StudentExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                studentException.getMessage() + "hellooo",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(studentExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
