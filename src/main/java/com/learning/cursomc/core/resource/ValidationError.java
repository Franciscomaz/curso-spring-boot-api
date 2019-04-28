package com.learning.cursomc.core.resource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldErrorMessage> errors;

    public ValidationError(Integer status,
                           String message,
                           LocalDateTime timeStamp) {
        super(status, message, timeStamp);
        errors = new ArrayList<>();
    }

    public List<FieldErrorMessage> getErrors() {
        return errors;
    }

    public void addFieldError(final FieldErrorMessage fieldError) {
        this.errors.add(fieldError);
    }
}
