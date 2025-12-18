package com.lut.billingservice.exceptionconfig;

import lombok.Data;

/**
 * A DTO for API error responses
 */
@Data
public class APIError {
    private final String message;
    private final String exception;

    public APIError(String message, String exception) {
        this.message = message;
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public String getException() {
        return exception;
    }
}
