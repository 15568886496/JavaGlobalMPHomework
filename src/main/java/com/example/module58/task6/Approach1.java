package com.example.module58.task6;

import com.example.module58.task3.Consumer;
import com.example.module58.task3.MessageBus;
import com.example.module58.task3.Producer;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/26/2022 10:10 PM
 **/
public class Approach1 {

  private static boolean flag = true;

  public static void calculateSum() {
    //init message bus
    ProducerAndConsumer ba = new ProducerAndConsumer();

    Thread consumerThread = new Thread(() -> {
      while (flag){
        ba.consumer();
      }
    });
    Thread producerThread = new Thread(() -> {
      while (flag){
        ba.producer();
      }
    });
    consumerThread.start();
    producerThread.start();
    try {
      Thread.sleep(1000);
      flag = false;
      System.out.println("ops/sec= " + ba.atomicInteger);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
