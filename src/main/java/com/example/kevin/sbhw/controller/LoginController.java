package com.example.kevin.sbhw.controller;

import com.example.kevin.sbhw.dto.ResponseResult;
import com.example.kevin.sbhw.entity.User;
import com.example.kevin.sbhw.service.LoginServcie;
import com.example.kevin.sbhw.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/user/registry")
    public ResponseResult registry(@RequestBody User user){
        userDetailsService.registry(user);
        return new ResponseResult(200,"success");
    }

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }

    @GetMapping("/hello")
    public ResponseResult hello(){
        System.out.println("-------------->hello");
        return new ResponseResult(200,"success","hello world");
    }
}
