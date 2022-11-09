package com.example.module58.task5;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/27/2022 8:55 PM
 **/
@Data
public class CurrencyAndRateModel {

  private BigDecimal rate;

  private String currency;

  private BigDecimal total;

}
