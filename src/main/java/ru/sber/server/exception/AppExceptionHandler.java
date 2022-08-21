package ru.sber.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ValidationFailedException.class)
    protected ResponseEntity<Error> handleValidationFailed(ValidationFailedException ex) {
        Error error = new Error(400, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
