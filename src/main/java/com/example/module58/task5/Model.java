package com.example.module58.task5;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/26/2022 8:44 PM
 **/
@Data
public class Model {

  private String userAccount;

  private List<CurrencyAndRateModel> list;
}
