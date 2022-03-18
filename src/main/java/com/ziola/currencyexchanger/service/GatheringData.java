package com.ziola.currencyexchanger.service;

import com.ziola.currencyexchanger.NBP.Connector;
import com.ziola.currencyexchanger.NBP.NbpRates;
import com.ziola.currencyexchanger.errors.CurrencyNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class GatheringData {

    private Connector connector;
    Map<String, NbpRates> allCurrencies;

    public GatheringData(Connector connector) {
        this.connector = connector;
        updateCurrencies();
    }

    private void updateCurrencies() {
        allCurrencies = connector.consumeCurrencies();
    }

    public BigDecimal findCurrencyMid(String code) {
        NbpRates result = allCurrencies.get(code);
        if (result == null)
            throw new CurrencyNotFoundException("Currency has not been found!");
        return result.getMid();
    }
}
