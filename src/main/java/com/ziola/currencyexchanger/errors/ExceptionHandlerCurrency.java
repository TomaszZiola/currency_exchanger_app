package com.ziola.currencyexchanger.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerCurrency {

    @ExceptionHandler(CurrencyInputEmptyException.class)
    public ResponseEntity<ErrorCurrency> currencyInputEmpty() {
        ErrorCurrency error = new ErrorCurrency("Fields cannot be empty!");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
