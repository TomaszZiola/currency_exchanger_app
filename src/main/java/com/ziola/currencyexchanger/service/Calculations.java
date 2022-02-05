package com.ziola.currencyexchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class Calculations {

    private final GatheringData gatheringData;

    public String calculateExchangedAmount(String toExchange, String exchanged, String amountToExchange) {

        BigDecimal amount = BigDecimal.valueOf(Double.valueOf(amountToExchange));
        BigDecimal midToExchange = gatheringData.findCurrencyMid(toExchange);
        BigDecimal midExchanged = gatheringData.findCurrencyMid(exchanged);

        return String.valueOf((amount.multiply(midToExchange).divide(midExchanged, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP));
    }
}
