package com.example.kevin.sbhw.controller;

import com.example.kevin.sbhw.dto.ResponseResult;
import com.example.kevin.sbhw.entity.User;
import com.example.kevin.sbhw.service.LoginServcie;
import com.example.kevin.sbhw.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
        try{
            return loginServcie.login(user);
        }catch (Exception e){
            return new ResponseResult(400,e.getMessage());
        }
    }
    @PostMapping("/user/logout")
    public ResponseResult logout(@RequestBody User user){
            return loginServcie.logout(user);
    }
    @GetMapping("/getBlockUser")
    public ResponseResult getBlockUser(){
        return loginServcie.getBlockUser();
    }

    @PreAuthorize("hasAuthority('view_info')")
    @GetMapping("/info")
    public ResponseResult info(){
        return new ResponseResult(200,"success","MVC APPLICATION");
    }

    @PreAuthorize("hasAuthority('view_admin')")
    @GetMapping("/admin")
    public ResponseResult admin(){
        return new ResponseResult(200,"success","MVC APPLICATION");
    }
    @GetMapping("/about")
    public ResponseResult about(){
        return new ResponseResult(200,"success","MVC APPLICATION");
    }
}
