package com.ziola.currencyexchanger.controllers;

import com.ziola.currencyexchanger.dto.CurrencyRequestDto;
import com.ziola.currencyexchanger.dto.CurrencyResponseDto;
import com.ziola.currencyexchanger.errors.CurrencyInputEmptyException;
import com.ziola.currencyexchanger.service.Calculations;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.isAnyBlank;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;

@RestController
@RequiredArgsConstructor
public class ExchangeCurrencyController {

    private final Calculations calculations;

    @PostMapping("/exchange")
    public CurrencyResponseDto exchangeGivenCurrency(@RequestBody CurrencyRequestDto currencyInputDto) {

        checkIfCorrect(currencyInputDto);
        final String currency = currencyInputDto.getCurrency();
        final String targetCurrency = currencyInputDto.getTargetCurrency();
        final String value = currencyInputDto.getValue();
        final String exchangedValue = calculations.calculateExchangedAmount(currencyInputDto.getTargetCurrency(),
                currencyInputDto.getCurrency(), currencyInputDto.getValue());

        CurrencyResponseDto result = new CurrencyResponseDto.Builder()
                .previousCurrency(targetCurrency)
                .currency(currency)
                .previousValue(value)
                .value(exchangedValue)
                .build();

        return result;
    }

    private void checkIfCorrect(CurrencyRequestDto currencyInputDto) {

        final String currency = currencyInputDto.getCurrency();
        final String targetCurrency = currencyInputDto.getTargetCurrency();
        final String value = currencyInputDto.getValue();

        if (isAnyBlank(currency, targetCurrency))
            throw new CurrencyInputEmptyException("Currency fields cannot be empty!");
        else if(isBlank(value) || !isParsable(value))
        throw new CurrencyInputEmptyException("Currency value must be a valid number!");
    }

}
