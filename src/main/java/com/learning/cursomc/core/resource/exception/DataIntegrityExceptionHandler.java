package com.learning.cursomc.core.resource.exception;

import com.learning.cursomc.core.application.exception.DataIntegrityException;
import com.learning.cursomc.core.application.exception.StandardExceptionHandler;
import com.learning.cursomc.core.resource.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataIntegrityExceptionHandler extends StandardExceptionHandler {

    @Override
    @ExceptionHandler(value = DataIntegrityException.class)
    public ResponseEntity<StandardError> handleException(Exception e) {
        return getResponse(e, HttpStatus.BAD_REQUEST);
    }
}
