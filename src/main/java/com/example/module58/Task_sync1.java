package com.example.module58;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 10/30/2022 4:04 PM
 **/
@Slf4j
public class Task_sync1 {

  private Map<Integer,Integer> map = new HashMap<>();

  private Integer total = 1000000;

  private Integer index = 0;

  public void addNumber(){
    log.info("current time = " + System.currentTimeMillis());
    while (total>index){
      index++;
      synchronized (map){        map.put(index,index);
      }
    }
    log.info("finish time = " + System.currentTimeMillis());
  }
  //jdk 11   time = 60
  //16:14:01.813 [main] INFO com.example.module58.Task_sync1 - current time = 1667117641841
  //16:14:01.901 [main] INFO com.example.module58.Task_sync1 - finish time = 1667117641901

  //jdk 10    time = 73
  //20:10:16.453 [main] INFO com.example.module58.Task_sync1 - current time = 1667131816451
  //20:10:16.524 [main] INFO com.example.module58.Task_sync1 - finish time = 1667131816524

  //jdk 8     time = 73
  //20:12:12.497 [main] INFO com.example.module58.Task_sync1 - current time = 1667131932496
  //20:12:12.569 [main] INFO com.example.module58.Task_sync1 - finish time = 1667131932569

  //jdk 6     time = 163
  //20:08:48.061 [main] INFO com.example.module58.Task_sync1 - current time = 1667131728057
  //20:08:48.220 [main] INFO com.example.module58.Task_sync1 - finish time = 1667131728220
}
