package com.ziola.currencyexchanger.NBP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NbpResponse {

   private String table;
   private String no;
   private LocalDate effectiveDate;
   private List<NbpRates> rates;
}
