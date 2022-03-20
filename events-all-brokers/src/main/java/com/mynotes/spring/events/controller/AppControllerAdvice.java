package com.mynotes.spring.events.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler({ ValidationException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex) {
        return new ResponseEntity<Object>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
