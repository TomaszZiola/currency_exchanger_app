package com.ziola.currencyexchanger.service;

import com.ziola.currencyexchanger.NBP.Connector;
import com.ziola.currencyexchanger.NBP.NbpRates;
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
        return allCurrencies.get(code).getMid();
    }
}
