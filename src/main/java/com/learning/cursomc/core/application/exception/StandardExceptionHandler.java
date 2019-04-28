package com.learning.cursomc.core.application.exception;

import com.learning.cursomc.core.resource.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class StandardExceptionHandler<T extends Exception> {

    public abstract ResponseEntity<StandardError> handleException(T e);

    public ResponseEntity<StandardError> getResponse(StandardError error, HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(error);
    }

}
