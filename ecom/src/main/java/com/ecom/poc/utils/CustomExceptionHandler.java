package com.ecom.poc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<String> handleException(ClassCastException exception){
        exception.printStackTrace();
        return new ResponseEntity<>("Exception while casting input", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException exception){
        exception.printStackTrace();
        return new ResponseEntity<>("Problem in either request or response ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
