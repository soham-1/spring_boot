package com.example.restpractices.configuration;

import com.example.restpractices.exception.EmployeeNotFoundException;
import com.example.restpractices.response.EmployeeResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeResponseEntity> handleStudentNotFoundException(EmployeeNotFoundException ex) {
        EmployeeResponseEntity employeeResponseEntity = new EmployeeResponseEntity();
        employeeResponseEntity.setCode(HttpStatus.NOT_FOUND.value());
        employeeResponseEntity.setMessage(ex.getMessage());
        employeeResponseEntity.setLocalDateTime(LocalDate.now().atStartOfDay());

        return new ResponseEntity<>(employeeResponseEntity, HttpStatus.NOT_FOUND);
    }
}
