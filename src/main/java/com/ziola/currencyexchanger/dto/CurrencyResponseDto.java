package com.ziola.currencyexchanger.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyResponseDto {

    String previousCurrency;
    String currency;
    String previousValue;
    String value;

    public static class Builder {
        String previousCurrency;
        String currency;
        String previousValue;
        String value;

        public Builder previousCurrency(String val) {
            previousCurrency = val;
            return this;
        }

        public Builder currency(String val) {
            currency = val;
            return this;
        }

        public Builder previousValue(String val) {
            previousValue = val;
            return this;
        }

        public Builder value(String val) {
            value = val;
            return this;
        }

        public CurrencyResponseDto build() {
            return new CurrencyResponseDto(this);
        }
    }

    public CurrencyResponseDto(Builder builder) {
        previousCurrency = builder.previousCurrency;
        currency = builder.currency;
        previousValue = builder.previousValue;
        value = builder.value;
    }
}
