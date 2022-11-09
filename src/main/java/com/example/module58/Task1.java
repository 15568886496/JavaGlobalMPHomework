package com.example.module58;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/17/2022 8:06 PM
 **/
public class Task1 {

  // unsafe
  private Map<Integer,Integer> map = new HashMap<>();

  //safe
  private Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

  //safe
  private Map<Integer, Integer> synchronizedMap = Collections.synchronizedMap(map);

  private Integer sum = 0;

  private Random random = new Random();

  public void method1(){
    new Thread(() -> {
      Integer index = 0;
      while (index<100){
        index++;
        map.put(random.nextInt(),random.nextInt());
      }
    }).start();
    new Thread(()->{
      for(Integer integer : map.values()){
        sum += integer;
      }
      System.out.print("SUM = "+sum);
    }).start();
  }


  public void method2(){
    new Thread(() -> {
      Integer index = 0;
      while (index<100){
        index++;
        concurrentHashMap.put(random.nextInt(),random.nextInt());
      }
    }).start();
    new Thread(()->{
      for(Integer integer : concurrentHashMap.values()){
        sum += integer;
      }
      System.out.print("SUM = "+sum);
    }).start();
  }

  public void method3(){
    new Thread(() -> {
      Integer index = 0;
      while (index<100){
        index++;
        synchronizedMap.put(random.nextInt(),random.nextInt());
      }
    }).start();
    new Thread(()->{
      for(Integer integer : synchronizedMap.values()){
        sum += integer;
      }
      System.out.print("SUM = "+sum);
    }).start();
  }

}
