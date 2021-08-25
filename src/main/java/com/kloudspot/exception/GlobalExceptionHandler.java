package com.kloudspot.exception;

import java.time.LocalDateTime;

import com.kloudspot.models.ApiError;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {

        String message = ex.getMessage();
        ApiError error = new ApiError(LocalDateTime.now(), message, status);

        return ResponseEntity.status(status).headers(headers).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
            HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {

        String message = ex.getMessage();
        ApiError error = new ApiError(LocalDateTime.now(), message, status);

        return ResponseEntity.status(status).headers(headers).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMessage();
        ApiError error = new ApiError(LocalDateTime.now(), message, status);

        return ResponseEntity.status(status).headers(headers).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getMessage();
        ApiError error = new ApiError(LocalDateTime.now(), message, status);

        return ResponseEntity.status(status).headers(headers).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "User Not Found");

        String message = ex.getMessage();
        ApiError error = new ApiError(LocalDateTime.now(), message, HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(error);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFound(ProductNotFoundException ex) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Product Not Found");

        String message = ex.getMessage();
        ApiError error = new ApiError(LocalDateTime.now(), message, HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Boom");

        String message = ex.getMessage();
        ApiError error = new ApiError(LocalDateTime.now(), message, HttpStatus.EXPECTATION_FAILED);

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(headers).body(error);
    }

}
