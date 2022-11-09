package com.example.kevin.sbhw.service;

import com.example.kevin.sbhw.dao.MenuDao;
import com.example.kevin.sbhw.dao.UserDao;
import com.example.kevin.sbhw.dto.LoginUser;
import com.example.kevin.sbhw.dto.ResponseResult;
import com.example.kevin.sbhw.entity.Menu;
import com.example.kevin.sbhw.entity.User;
import com.example.kevin.sbhw.redis.RedisCache;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
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

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RedisCache redisCache;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //according username to get user info
        User user = userDao.getUserInfoByName(username);
        List<String> permissionKeyList = new ArrayList<>();
        if(username.equals("admin@google.com")){
            permissionKeyList =  menuDao.selectAdminRole();
        }else{
            permissionKeyList =  menuDao.selectPermsByUserId(user.getId());
        }
        return new LoginUser(user,permissionKeyList);
    }

    public void registry(User user) {
        user.setId(new Random().nextLong());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userDao.save(user);
    }
}

