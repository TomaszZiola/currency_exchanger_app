package com.ziola.currencyexchanger.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyOutputDto {

    String currencyToExchange;
    String currencyExchanged;
    String amountToExchange;
    String amountExchanged;

    public static class Builder {
        String currencyToExchange;
        String currencyExchanged;
        String amountToExchange;
        String amountExchanged;

        public Builder currencyToExchange(String val) {
            currencyToExchange = val;
            return this;
        }

        public Builder currencyExchanged(String val) {
            currencyExchanged = val;
            return this;
        }

        public Builder amountToExchange(String val) {
            amountToExchange = val;
            return this;
        }

        public Builder amountExchanged(String val) {
            amountExchanged = val;
            return this;
        }

        public CurrencyOutputDto build() {
            return new CurrencyOutputDto(this);
        }
    }

    public CurrencyOutputDto(Builder builder) {
        currencyToExchange = builder.currencyToExchange;
        currencyExchanged = builder.currencyExchanged;
        amountToExchange = builder.amountToExchange;
        amountExchanged = builder.amountExchanged;
    }
}
