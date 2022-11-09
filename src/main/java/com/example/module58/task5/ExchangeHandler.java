package com.example.module58.task5;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.checkerframework.checker.units.qual.C;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/27/2022 8:57 PM
 **/
public class ExchangeHandler {

  private List<CurrencyAndRateModel> currencyAndRateModels= this.getModel().getList();


  public Model getModel(){
    Model model = new Model();
    model.setUserAccount("kevin");
    CurrencyAndRateModel currencyAndRateModel = new CurrencyAndRateModel();
    currencyAndRateModel.setCurrency("US");
    currencyAndRateModel.setTotal(new BigDecimal(10));
    currencyAndRateModel.setRate(new BigDecimal(7.15));

    CurrencyAndRateModel currencyAndRateModel1 = new CurrencyAndRateModel();
    currencyAndRateModel1.setCurrency("EU");
    currencyAndRateModel1.setRate(new BigDecimal(8.15));
    currencyAndRateModel1.setTotal(new BigDecimal(20));

    model.setList(Arrays.asList(currencyAndRateModel,currencyAndRateModel1));
    return model;
  }

  public void handleExchangeRate(){
    ExecutorService executorService = Executors.newCachedThreadPool();

    synchronized (currencyAndRateModels){
      for(CurrencyAndRateModel currencyAndRateModel : currencyAndRateModels){
        executorService.submit(()->{
          BigDecimal money = currencyAndRateModel.getTotal().multiply(currencyAndRateModel.getRate());
        });
      }
    }
  }
}
