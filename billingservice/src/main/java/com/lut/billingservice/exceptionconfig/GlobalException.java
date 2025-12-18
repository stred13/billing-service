package com.lut.billingservice.exceptionconfig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the application
 */
@RestControllerAdvice
public class GlobalException {

    /**
     * Handles NullPointerExceptions thrown in the application
     *
     * @param ex the NullPointerException
     * @return a ResponseEntity containing an APIError with details
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIError> handleNullPointer(NullPointerException ex) {
        String msg = ex.getMessage() != null ? ex.getMessage() : "A required value was null";
        APIError body = new APIError("Bad request: " + msg, ex.getClass().getSimpleName());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
