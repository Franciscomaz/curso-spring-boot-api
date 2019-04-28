package com.learning.cursomc.core.resource.exception;

import com.learning.cursomc.core.application.exception.DataIntegrityException;
import com.learning.cursomc.core.application.exception.StandardExceptionHandler;
import com.learning.cursomc.core.resource.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class DataIntegrityExceptionHandler extends StandardExceptionHandler<DataIntegrityException> {

    @Override
    @ExceptionHandler(value = DataIntegrityException.class)
    public ResponseEntity<StandardError> handleException(DataIntegrityException e) {
        return getResponse(new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
