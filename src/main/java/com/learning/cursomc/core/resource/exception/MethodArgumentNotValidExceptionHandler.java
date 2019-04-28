package com.learning.cursomc.core.resource.exception;

import com.learning.cursomc.core.application.exception.StandardExceptionHandler;
import com.learning.cursomc.core.resource.FieldErrorMessage;
import com.learning.cursomc.core.resource.StandardError;
import com.learning.cursomc.core.resource.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler extends StandardExceptionHandler<MethodArgumentNotValidException> {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleException(MethodArgumentNotValidException e) {
        final ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", LocalDateTime.now());

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.addFieldError(new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        return getResponse(error, HttpStatus.BAD_REQUEST);
    }
}
