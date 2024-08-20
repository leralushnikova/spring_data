package com.lushnikova.jpa.controller.handler;

import com.lushnikova.jpa.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.net.URI;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Problem> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(buildProblem(ex, request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>("text", HttpStatusCode.valueOf(500));
    }

    private Problem buildProblem(Exception ex, WebRequest request){
        return Problem.builder()
                .withType(URI.create(request.getContextPath()))
                .withTitle(ex.getLocalizedMessage())
                .with("hello", "Lera")
                .withStatus(Status.INTERNAL_SERVER_ERROR)
                .withDetail(ex.getMessage())
                .build();
    }

    /*private ErrorDetails buildErrorDetails(Exception ex, WebRequest request) {
        var error = ErrorDetails.builder()
                .id(UUID.randomUUID())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .timestamp(LocalDateTime.now().toString())
                .build();
        log.warn(String.valueOf(error));
        return error;
    }*/


}
