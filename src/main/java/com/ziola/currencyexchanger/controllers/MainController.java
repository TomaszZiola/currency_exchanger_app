package com.ziola.currencyexchanger.controllers;

import com.ziola.currencyexchanger.NBP.Connector;
import com.ziola.currencyexchanger.dto.CurrencyInputDto;
import com.ziola.currencyexchanger.dto.CurrencyOutputDto;
import com.ziola.currencyexchanger.errors.CurrencyInputEmptyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @PostMapping
    public CurrencyOutputDto exchangeGivenCurrency(@RequestBody CurrencyInputDto currencyInputDto) {

        CurrencyInputDto currencyInputTemp = checkIfCorrect(currencyInputDto);

        CurrencyOutputDto result = new CurrencyOutputDto.Builder()
                .currencyToExchange(currencyInputTemp.getCurrencyToExchange())
                .currencyExchanged(currencyInputTemp.getCurrencyExchanged())
                .amountToExchange(currencyInputTemp.getAmountToExchange())
                .amountExchanged(currencyInputTemp.getAmountExchanged())
                .build();

        return result;
    }

    private CurrencyInputDto checkIfCorrect(CurrencyInputDto currencyInputDto) {

        if (currencyInputDto.getCurrencyExchanged().isBlank() ||
                currencyInputDto.getCurrencyToExchange().isBlank() ||
                currencyInputDto.getAmountExchanged().isBlank() ||
                currencyInputDto.getAmountExchanged().isBlank()) {

            throw new CurrencyInputEmptyException("Field cannot be empty!");
        }
        return currencyInputDto;
    }

}
