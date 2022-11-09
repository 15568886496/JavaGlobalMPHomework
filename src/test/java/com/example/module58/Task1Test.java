package com.example.module58;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/19/2022 10:19 PM
 **/
public class Task1Test {

  private Task1 task1 = new Task1();

  @Test
  public void testConcurrentModificationException(){
    task1.method1();
  }

  @Test
  public void testConcurrentHashMap(){
    task1.method2();
  }

  @Test
  public void testSynchronizedMap(){
    task1.method3();
  }

  @Test
  public void testPerformence(){
    Task_sync1 task_sync1 = new Task_sync1();
    task_sync1.addNumber();
  }
}
