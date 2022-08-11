package com.innowise.weather.activityworker.exeption;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException{
    private final HttpStatus status;

    protected ServiceException(HttpStatus status) {
        this.status = status;
    }

    public ServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ServiceException(Exception exception, HttpStatus status) {
        super(exception);
        this.status = status;
    }

    public ServiceException(String message, Exception exception, HttpStatus status) {
        super(message, exception);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
