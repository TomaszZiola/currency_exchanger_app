package com.ziola.currencyexchanger.controllers;

import com.ziola.currencyexchanger.dto.CurrencyInputDto;
import com.ziola.currencyexchanger.dto.CurrencyOutputDto;
import com.ziola.currencyexchanger.errors.CurrencyInputEmptyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping
    public CurrencyOutputDto exchangeGivenCurrency(@RequestBody CurrencyInputDto currencyInputDto) throws CurrencyInputEmptyException {

        checkIfCorrect(currencyInputDto);

        CurrencyOutputDto result = new CurrencyOutputDto.Builder()
                .currencyToExchange("0")
                .currencyExchanged("0")
                .amountToExchange("0")
                .amountExchanged("0")
                .build();

        return result;
    }

    private void checkIfCorrect(CurrencyInputDto currencyInputDto) throws CurrencyInputEmptyException {

        if(currencyInputDto.getCurrencyExchanged().length() == 0)
            throw new CurrencyInputEmptyException(currencyInputDto.getCurrencyExchanged());
        else if(currencyInputDto.getCurrencyToExchange().isEmpty())
            throw new CurrencyInputEmptyException(currencyInputDto.getCurrencyToExchange());
        else if (currencyInputDto.getAmountToExchange().isEmpty())
            throw new CurrencyInputEmptyException(currencyInputDto.getAmountToExchange());
        else if(currencyInputDto.getAmountExchanged() == null)
            throw new CurrencyInputEmptyException(currencyInputDto.getAmountExchanged());
    }
}
