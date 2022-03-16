package com.ziola.currencyexchanger.controllers;

import com.ziola.currencyexchanger.dto.CurrencyRequestDto;
import com.ziola.currencyexchanger.dto.CurrencyResponseDto;
import com.ziola.currencyexchanger.errors.CurrencyInputEmptyException;
import com.ziola.currencyexchanger.service.Calculations;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeCurrencyController {

    private final Calculations calculations;

    @PostMapping("/exchange")
    public CurrencyResponseDto exchangeGivenCurrency(@RequestBody CurrencyRequestDto currencyInputDto) {

        checkIfCorrect(currencyInputDto);

        CurrencyResponseDto result = new CurrencyResponseDto.Builder()
                .currencyToExchange(currencyInputDto.getTargetCurrency())
                .currencyExchanged(currencyInputDto.getCurrency())
                .amountToExchange(currencyInputDto.getValue())
                .amountExchanged(calculations.calculateExchangedAmount(currencyInputDto.getTargetCurrency(),
                        currencyInputDto.getCurrency(), currencyInputDto.getValue()))
                .build();

        return result;
    }

    private void checkIfCorrect(CurrencyRequestDto currencyInputDto) {

        if (currencyInputDto.getCurrency().isBlank() ||
                currencyInputDto.getTargetCurrency().isBlank() ||
                currencyInputDto.getValue().isBlank()){

            throw new CurrencyInputEmptyException("Field cannot be empty!");
        }
    }

}
