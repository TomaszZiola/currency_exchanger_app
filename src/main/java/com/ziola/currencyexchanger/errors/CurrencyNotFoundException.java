package com.ziola.currencyexchanger.errors;

import lombok.Getter;

@Getter
public class CurrencyNotFoundException extends RuntimeException{

    private String message;

    public CurrencyNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
