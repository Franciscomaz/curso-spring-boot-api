package com.learning.cursomc.core.application.exception;

public class DataIntegrityException extends RuntimeException{

    public DataIntegrityException() {
    }

    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }

}
