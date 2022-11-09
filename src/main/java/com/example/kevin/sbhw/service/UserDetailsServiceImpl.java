package com.example.kevin.sbhw.service;

import com.example.kevin.sbhw.dao.UserDao;
import com.example.kevin.sbhw.dto.LoginUser;
import com.example.kevin.sbhw.dto.ResponseResult;
import com.example.kevin.sbhw.entity.User;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.Random;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author kevin
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //according username to get user info
        User user = userDao.getUserInfoByName(username);
        //validate user exist
        if(Objects.isNull(user)){
            throw new RuntimeException("user not exist");
        }
        return new LoginUser(user);
    }

    public void registry(User user) {
        user.setId(new Random().nextLong());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userDao.save(user);
    }

    // implement delete and update function and return List pagenation
}

