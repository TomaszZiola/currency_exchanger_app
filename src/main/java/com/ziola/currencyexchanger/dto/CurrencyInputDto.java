package com.ziola.currencyexchanger.dto;

import lombok.Data;

@Data
public class CurrencyInputDto {

    String currencyToExchange;
    String currencyExchanged;
    String amountToExchange;
    String amountExchanged;
}
