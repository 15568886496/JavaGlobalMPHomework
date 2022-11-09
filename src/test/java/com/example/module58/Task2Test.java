package com.example.module58;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/19/2022 10:27 PM
 **/
public class Task2Test {

  private Map<String,String> map = new ConcurrentHashMap<>(150000000);

  @Test
  public void testMethod1(){
    Task2 task2 = new Task2();
    task2.method1();
  }

  @Test
  public void test(){
    System.out.print("startTime = "+ System.currentTimeMillis());
    Integer i = 0;
    while (i<10000000){
      map.put(i++ +"",i +"");
    }
    System.out.print("putTime = "+ System.currentTimeMillis());
    map.get("1");
    System.out.print("endTime = "+ System.currentTimeMillis());
  }

}
