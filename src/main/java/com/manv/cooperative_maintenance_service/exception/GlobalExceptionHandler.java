package com.manv.cooperative_maintenance_service.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> catchResourceNotFoundException(UserNotFoundException e) {
        logger.error(e.getMessage());
        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler
    public ResponseEntity<?> catchUuidNotEqualsException(UuidNotEqualsException e) {
        logger.error(e.getMessage());
        return new ResponseEntity<>(
                HttpStatus.NOT_ACCEPTABLE
        );
    }
}
