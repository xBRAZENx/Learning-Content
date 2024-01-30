package com.GlobalExceptionHandling.test.ControllerAdvice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.GlobalExceptionHandling.test.UserNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value 
      = { IllegalArgumentException.class, IllegalStateException.class,UserNotFoundException.class , NoSuchElementException.class})
    protected ResponseEntity<Object> handleUserError(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Invalid request";
        return new ResponseEntity<Object>(bodyOfResponse, HttpStatus.BAD_REQUEST);
    }
}