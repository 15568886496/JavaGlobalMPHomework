package com.example.modeloe10.cache;

import com.example.module10.cache.GuavaCacheService;
import com.example.module10.cache.util.GuavaCacheUtil;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/19/2022 2:17 PM
 **/
@RunWith(MockitoJUnitRunner.class)
public class GuavaCacheServiceTest {

  @InjectMocks
  private GuavaCacheService guavaCacheService;

  @Before
  public void init(){
    GuavaCacheUtil.cache.put("name","jack");
  }

  /**
   * test put
   */
  @Test
  public void testPut(){
    guavaCacheService.put("age", "30");
    Assert.assertTrue(true);
  }


  /**
   * test get attributes form cache
   */
  @Test
  public void testGet(){
    String name = guavaCacheService.get("name");
    Assert.assertTrue("jack".equals(name));
  }


  /**
   * test eviction and removeListener
   */
  @Test
  public void testEviction(){
    ExecutorService executorService = Executors.newCachedThreadPool();
    CountDownLatch countDownLatch = new CountDownLatch(GuavaCacheUtil.MAXIMUMSIZE-1);
    //mock put element to cache.
    for(int i = 0; i< GuavaCacheUtil.MAXIMUMSIZE-1; i++){
      int finalIndex = i;
      executorService.execute(() -> {
        try{
          GuavaCacheUtil.cache.put(String.valueOf(finalIndex),String.valueOf(finalIndex));
        }finally {
          countDownLatch.countDown();
        }
      });
    }
    try {
      countDownLatch.await();
      guavaCacheService.put("age", "30");
      Assert.assertTrue(GuavaCacheUtil.evictionCount.intValue()>0);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
