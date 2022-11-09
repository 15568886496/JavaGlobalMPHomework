package com.example.modeloe10.cache;

import com.example.module10.cache.SimpleCacheEvent;
import com.example.module10.cache.SimpleCacheService;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Stubber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 9/19/2022 3:05 PM
 **/
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SimpleCacheServiceTest {

  @InjectMocks
  private SimpleCacheService simpleCacheService;

  @Mock
  private ApplicationContext applicationContext;

  @Test
  public void testPut(){
    String value = simpleCacheService.put("key", "simpleCache");
    Assert.assertTrue(value.equals("simpleCache"));
  }

  @Test
  public void testGet(){
    String key = simpleCacheService.get("key");
    Assert.assertTrue(StringUtils.isEmpty(key));
  }

}
