package com.heavenhr.web.business.error;

import java.time.LocalTime;

public class ErrorMessage {
    private int code;
    private String message;
    private LocalTime timestamp = LocalTime.now();

    public ErrorMessage() {
    }

    public ErrorMessage(ErrorCodes errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
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

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalTime timestamp) {
        this.timestamp = timestamp;
    }

}
