package com.learning.cursomc.core.application.exception;

import com.learning.cursomc.core.resource.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public abstract class StandardExceptionHandler {

    public abstract ResponseEntity<StandardError> handleException(Exception e);

    public ResponseEntity<StandardError> getResponse(Exception e, HttpStatus status) {
        StandardError error = new StandardError(status.value(), e.getMessage(), LocalDateTime.now());
        return ResponseEntity
                .status(status)
                .body(error);
    }

}
