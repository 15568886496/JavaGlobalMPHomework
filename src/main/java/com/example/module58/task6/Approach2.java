package com.example.module58.task6;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/26/2022 8:55 PM
 **/
@Slf4j
public class Approach2 {

  private static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(100000);

  private Integer averageValue = 0;

  private static AtomicInteger atomicInteger = new AtomicInteger(0);

  public static void calculateSum() throws InterruptedException {
    ExecutorService producePool = Executors.newCachedThreadPool();
    producePool.submit(()->{
      while (true){
        arrayBlockingQueue.put(new Random().nextInt());
      }
    });

    ExecutorService consumePool = Executors.newCachedThreadPool();
    consumePool.submit(()->{
      while (arrayBlockingQueue.size()>0){
        atomicInteger.getAndAdd(1);
      }
    });

    Thread.sleep(1000);
    System.out.println("ops/sec= " + atomicInteger);
    producePool.shutdown();
    consumePool.shutdown();
    //150000 ops/sec
  }

  public static void main(String[] args) throws InterruptedException {
    calculateSum();
  }
}
