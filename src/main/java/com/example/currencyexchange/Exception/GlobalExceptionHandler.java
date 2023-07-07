package com.example.currencyexchange.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = CurrencyNotFoundException.class) {
//    public ResponseEntity<?> currencyNotFound(CurrencyNotFoundException currencyNotFoundException) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse().getMessage());
//    }

    @ExceptionHandler(value = CurrencyNotFoundException.class)
    public ResponseEntity<?> currencyNotFound(CurrencyNotFoundException currencyNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(currencyNotFoundException.getMessage()));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> generalExp(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(exception.getMessage()));
    }


}
