package com.ziola.currencyexchanger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyInputDto {

    String currencyToExchange;
    String currencyExchanged;
    String amountToExchange;
}
