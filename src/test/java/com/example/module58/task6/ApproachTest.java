package com.example.module58.task6;

import org.junit.Test;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/26/2022 9:09 PM
 **/
public class ApproachTest {

  @Test
  public void testCalculateSum1() {
    // 400000|290000|270000 ops/sec
    Approach1 approach1 = new Approach1();
    approach1.calculateSum();
  }

  @Test
  public void testCalculateSum() throws InterruptedException {
    //320000|270000|340000 ops/sec
    Approach2 approach2 = new Approach2();
    approach2.calculateSum();
  }


}
