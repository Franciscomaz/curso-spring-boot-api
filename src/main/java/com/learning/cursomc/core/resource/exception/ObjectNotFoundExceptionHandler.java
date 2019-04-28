package com.learning.cursomc.core.resource.exception;

import com.learning.cursomc.core.application.exception.ObjectNotFound;
import com.learning.cursomc.core.application.exception.StandardExceptionHandler;
import com.learning.cursomc.core.resource.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ObjectNotFoundExceptionHandler extends StandardExceptionHandler<ObjectNotFound> {

    @Override
    @ExceptionHandler(value = ObjectNotFound.class)
    public ResponseEntity<StandardError> handleException(ObjectNotFound e) {
        return getResponse(new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
