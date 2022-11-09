package com.example.kevin.sbhw.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import com.example.kevin.sbhw.dao.UserDao;
import com.example.kevin.sbhw.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 10/10/2022 8:29 PM
 **/
@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

  @InjectMocks
  private UserDetailsServiceImpl userDetailsService;

  @Mock
  private UserDao userDao;

  @Test
  public void test(){
    Mockito.when(userDao.getUserInfoByName(anyString())).thenReturn(new User());
    userDetailsService.loadUserByUsername("kevin");
  }

}