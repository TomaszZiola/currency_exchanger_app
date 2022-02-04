package com.ziola.currencyexchanger.errors;

import lombok.Getter;

@Getter
public class CurrencyInputEmptyException extends RuntimeException {

    private String message;

    public CurrencyInputEmptyException(String message) {
        super(message);
        this.message = message;
    }
}
