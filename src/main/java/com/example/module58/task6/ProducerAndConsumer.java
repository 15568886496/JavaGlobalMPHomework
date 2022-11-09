package com.example.module58.task6;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/27/2022 1:27 PM
 **/
public class ProducerAndConsumer {

  private LinkedList<Integer> list = new LinkedList();

  public AtomicInteger atomicInteger = new AtomicInteger(0);

  public synchronized void producer(){
    list.add(new Random().nextInt());
    notifyAll();
  }

  public synchronized void consumer(){
    if (list.isEmpty()) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } else {
      atomicInteger.getAndAdd(1);
    }
  }

}
