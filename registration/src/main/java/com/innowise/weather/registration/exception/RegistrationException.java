package com.innowise.weather.registration.exception;

public class RegistrationException extends RuntimeException{
    protected RegistrationException() {
    }

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(Exception exception) {
        super(exception);
    }

    public RegistrationException(String message, Exception exception) {
        super(message, exception);
    }
}
