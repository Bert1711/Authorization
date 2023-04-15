package com.example.authorization.advice;

import com.example.authorization.exceptions.InvalidCredentials;
import com.example.authorization.exceptions.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class ExceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentials ex) {
        return new ResponseEntity<>("INVALID_CREDENTIALS: " + ex.getMessage(),HttpStatus.BAD_REQUEST);
    }@ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUserException(UnauthorizedUser ex) {
        System.err.println(ex.getMessage());
        return new ResponseEntity<>("INVALID_CREDENTIALS: " + ex.getMessage(),HttpStatus.UNAUTHORIZED);
    }
}
