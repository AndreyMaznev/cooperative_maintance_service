package com.manv.cooperative_maintenance_service.exception;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    public ErrorMessage catchUserNotFoundException(UserNotFoundException e) {
        logger.error(e.getMessage());
        String userFriendlyMessage = "User not found.";
        return new ErrorMessage (userFriendlyMessage);
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler
    public ErrorMessage catchIdNotEqualsException(IdNotEqualsException e) {
        logger.error(e.getMessage());
        String userFriendlyMessage = "Not acceptable id for this user.";
        return new ErrorMessage (userFriendlyMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorMessage catchUsernameAlreadyInUseException(UsernameAlreadyInUseException e) {
        logger.error(e.getMessage());
        String userFriendlyMessage = "Username already in use.";
        return new ErrorMessage (userFriendlyMessage);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorMessage catchEmailAlreadyInUseException(EmailAlreadyInUseException e) {
        logger.error(e.getMessage());
        String userFriendlyMessage = "Email already in use.";
        return new ErrorMessage (userFriendlyMessage);
    }
}
