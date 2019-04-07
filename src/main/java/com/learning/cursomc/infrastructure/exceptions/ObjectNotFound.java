package com.learning.cursomc.infrastructure.exceptions;

public class ObjectNotFound extends RuntimeException{

    public ObjectNotFound() {
    }

    public ObjectNotFound(String message) {
        super(message);
    }

    public ObjectNotFound(String message, Throwable cause) {
        super(message, cause);
    }

}
