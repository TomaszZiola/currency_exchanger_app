package com.ziola.currencyexchanger.controllers;

import com.ziola.currencyexchanger.NBP.Connector;
import com.ziola.currencyexchanger.dto.CurrencyInputDto;
import com.ziola.currencyexchanger.dto.CurrencyOutputDto;
import com.ziola.currencyexchanger.errors.CurrencyInputEmptyException;
import com.ziola.currencyexchanger.service.Calculations;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final Calculations calculations;

    @PostMapping
    public CurrencyOutputDto exchangeGivenCurrency(@RequestBody CurrencyInputDto currencyInputDto) {

        CurrencyInputDto currencyInputTemp = checkIfCorrect(currencyInputDto);

        CurrencyOutputDto result = new CurrencyOutputDto.Builder()
                .currencyToExchange(currencyInputTemp.getCurrencyToExchange())
                .currencyExchanged(currencyInputTemp.getCurrencyExchanged())
                .amountToExchange(currencyInputTemp.getAmountToExchange())
                .amountExchanged(calculations.calculateExchangedAmount(currencyInputTemp.getCurrencyToExchange(), currencyInputTemp.getCurrencyExchanged(), currencyInputTemp.getAmountToExchange()))
                .build();

        return result;
    }

    private CurrencyInputDto checkIfCorrect(CurrencyInputDto currencyInputDto) {

        if (currencyInputDto.getCurrencyExchanged().isBlank() ||
                currencyInputDto.getCurrencyToExchange().isBlank() ||
                currencyInputDto.getAmountToExchange().isBlank()){

            throw new CurrencyInputEmptyException("Field cannot be empty!");
        }
        return currencyInputDto;
    }

}
