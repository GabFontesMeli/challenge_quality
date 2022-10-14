package com.example.challenge_quality.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetails> handleInvalidFields(MethodArgumentNotValidException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Dados inválidos")
                .message(ex.getFieldError().getDefaultMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now()) 
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleException(Exception e) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
            .title("Internal Server Error")
            .message("Ocorreu um erro inesperado")
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .timeStamp(LocalDateTime.now())
            .build();
        System.out.println("Erro desconhecido: " + e.getMessage());
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
