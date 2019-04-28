package com.learning.cursomc.core.resource;

public class FieldErrorMessage {

    private String field;
    private String message;

    public FieldErrorMessage() {
    }

    public FieldErrorMessage(String fieldName, String message) {
        this.field = fieldName;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
