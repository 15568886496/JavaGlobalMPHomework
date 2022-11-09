package com.example.kevin.sbhw.service;

import com.example.kevin.sbhw.dto.ResponseResult;
import com.example.kevin.sbhw.entity.User;

/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 10/8/2022 5:09 PM
 **/
public interface LoginServcie {

   ResponseResult login(User user);

   ResponseResult logout();

}
