package com.ziola.currencyexchanger.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerCurrency {

    @ExceptionHandler(CurrencyInputEmptyException.class)
    public ResponseEntity<ErrorCurrency> currencyInputEmpty(CurrencyInputEmptyException e) {
        ErrorCurrency error = new ErrorCurrency(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<ErrorCurrency> currencyNotFound(CurrencyNotFoundException e) {
        ErrorCurrency error = new ErrorCurrency(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
