package com.learning.cursomc.common.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class StandardError {

    @JsonProperty
    private Integer status;

    @JsonProperty
    private String message;

    @JsonProperty
    private LocalDateTime timeStamp;

    public StandardError(Integer status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Integer status() {
        return status;
    }

    public String message() {
        return message;
    }

    public LocalDateTime timeStamp() {
        return timeStamp;
    }
}
