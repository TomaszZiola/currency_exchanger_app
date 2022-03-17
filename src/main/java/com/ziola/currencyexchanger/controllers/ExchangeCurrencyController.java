package com.ziola.currencyexchanger.controllers;

import com.ziola.currencyexchanger.dto.CurrencyRequestDto;
import com.ziola.currencyexchanger.dto.CurrencyResponseDto;
import com.ziola.currencyexchanger.errors.CurrencyInputEmptyException;
import com.ziola.currencyexchanger.service.CalculationsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.StringUtils.isAnyBlank;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;

@RestController
@RequiredArgsConstructor
public class ExchangeCurrencyController {

    private final CalculationsImpl calculationsImpl;

    @PostMapping("/exchange")
    public CurrencyResponseDto exchangeGivenCurrency(@RequestBody CurrencyRequestDto currencyRequestDto) {

        checkIfCorrect(currencyRequestDto);
        final String currency = currencyRequestDto.getCurrency();
        final String targetCurrency = currencyRequestDto.getTargetCurrency();
        final String value = currencyRequestDto.getValue();
        final String exchangedValue = calculationsImpl.calculateExchangedAmount(currencyRequestDto.getTargetCurrency(),
                currencyRequestDto.getCurrency(), currencyRequestDto.getValue());

        CurrencyResponseDto result = new CurrencyResponseDto.Builder()
                .previousCurrency(targetCurrency)
                .currency(currency)
                .previousValue(value)
                .value(exchangedValue)
                .build();

        return result;
    }

    private void checkIfCorrect(CurrencyRequestDto currencyRequestDto) {

        final String currency = currencyRequestDto.getCurrency();
        final String targetCurrency = currencyRequestDto.getTargetCurrency();
        final String value = currencyRequestDto.getValue();

        if (isAnyBlank(currency, targetCurrency))
            throw new CurrencyInputEmptyException("Currency fields cannot be empty!");
        else if (isBlank(value) || !isParsable(value))
            throw new CurrencyInputEmptyException("Currency value must be a valid number!");
    }

}
