package com.example.module58;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/17/2022 9:03 PM
 **/
public class Task2 {

  private Random random = new Random();

  private double sum = 0;

  public void method1(){
    Set<Integer> set = new HashSet<>();

      Thread t1 = new Thread(()-> {
        Integer index = 0;
        while (index<Integer.MAX_VALUE){
          index++;
          synchronized (this){
            set.add(random.nextInt());
          }
        }
      });
      t1.start();

        Thread t2 = new Thread(()-> {
          synchronized (this) {
            for (Integer integer : set) {
              sum += integer;
            }
            System.out.print("SUM = " + sum);
          }
        });
        t2.start();
        Thread t3 = new Thread(()-> {
          synchronized (this) {
            for (Integer integer : set) {
              sum += Math.pow(integer, 2);
            }
            System.out.print("The square root of SUM = " +  Math.sqrt(sum));
          }
        });
        t3.start();

  }

}
