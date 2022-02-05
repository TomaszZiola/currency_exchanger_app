package com.ziola.currencyexchanger.NBP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NbpRates {

    private String code;
    private String currency;
    private BigDecimal mid;
}
