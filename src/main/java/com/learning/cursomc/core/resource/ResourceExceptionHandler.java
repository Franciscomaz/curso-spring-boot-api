package com.learning.cursomc.core.resource;

import com.learning.cursomc.core.application.ObjectNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFound e, HttpServletRequest request) {
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

}
