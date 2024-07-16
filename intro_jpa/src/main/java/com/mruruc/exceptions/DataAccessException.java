package com.mruruc.exceptions;

public class DataAccessException extends RuntimeException {
    public DataAccessException(String message, Exception exception) {
        super(message,exception);
    }
}
