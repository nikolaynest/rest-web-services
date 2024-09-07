package com.nest.webservices.rest_web_services.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .details(request.getDescription(true))
                .build();
        return ResponseEntity.internalServerError().body(errorDetails);
    }

    @ExceptionHandler(PetFriendNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFoundException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .details(request.getDescription(true))
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String messages = ex.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .message(messages)
                .details(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}

