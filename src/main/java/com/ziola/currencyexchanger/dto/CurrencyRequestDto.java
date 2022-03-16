package com.ziola.currencyexchanger.dto;
import lombok.Getter;

@Getter
public class CurrencyRequestDto {

    String targetCurrency;
    String currency;
    String value;

}
