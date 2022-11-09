package com.example.kevin.sbhw.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.kevin.sbhw.entity.User;
import com.example.kevin.sbhw.redis.RedisCache;
import com.example.kevin.sbhw.service.LoginServcie;
import com.example.kevin.sbhw.service.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


/**
 * TODO
 * <p>
 * User: Kevin_Li1 DATE: 10/10/2022 5:35 PM
 **/
@RunWith(SpringRunner.class)
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class))
@WebMvcTest(controllers={LoginController.class})
class LoginControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private RedisCache redisCache;

  @MockBean
  private LoginServcie loginServcie;

  @MockBean
  private UserDetailsServiceImpl userDetailsService;

  @SneakyThrows
  @Test
  void testRegistry() {
    mvc.perform(post("/user/registry")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(new User())))
        .andExpect(status().is(200));

  }


}