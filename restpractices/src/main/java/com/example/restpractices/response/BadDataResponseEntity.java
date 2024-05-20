package com.example.restpractices.response;

import java.time.LocalDateTime;

public class BadDataResponseEntity {
    private int code;
    private String message;
    private LocalDateTime localDateTime;

    public BadDataResponseEntity() {
    }

    public BadDataResponseEntity(int code, String message, LocalDateTime localDateTime) {
        this.code = code;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
