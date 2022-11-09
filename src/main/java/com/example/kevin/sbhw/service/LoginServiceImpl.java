package com.example.kevin.sbhw.service;

import com.example.kevin.sbhw.dao.UserDao;
import com.example.kevin.sbhw.dto.LoginUser;
import com.example.kevin.sbhw.dto.ResponseResult;
import com.example.kevin.sbhw.entity.User;
import com.example.kevin.sbhw.util.JwtUtil;
import com.example.kevin.sbhw.redis.RedisCache;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @Author kevin
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginServcie {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = null;
        try{
             authenticate = authenticationManager.authenticate(authenticationToken);
        }catch (BadCredentialsException e) {
            String key = user.getUserName()+"-errorCount";
            if(redisCache.getCacheObject(key) == null){
                redisCache.setCacheObject(key,1,5, TimeUnit.MINUTES);
            }else {
                Integer k = redisCache.getCacheObject(key);
                redisCache.setCacheObject(key,k + 1);
                if(k+1 > 3){
                    User userInfoByName = userDao.getUserInfoByNameWithoutStatus(user.getUserName());
                    userInfoByName.setStatus("1");
                    userDao.save(userInfoByName);
                    redisCache.setCacheObject(key,k+1, 60, TimeUnit.MINUTES);
                    throw new RuntimeException("The account is locked 60 minutes");
                }
            }
            throw new RuntimeException("username or password is Invalid");
        }catch (NullPointerException e){
            throw new RuntimeException("user is invalid or is locked");
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("user not exist");
        }
        //generate token by userId
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //add authenticate to redis
        redisCache.setCacheObject("login:"+loginUser.getUsername(),loginUser);
        //return token
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"success login",map);
    }

    @Override
    public ResponseResult logout(User user) {
        redisCache.deleteObject("login:"+user.getUserName());
        String key = user.getUserName()+"-errorCount";
        redisCache.deleteObject(key);
        return new ResponseResult(200,"log out");
    }

    @Override
    public ResponseResult getBlockUser() {
        return new ResponseResult(200,userDao.getBlockUser());
    }

}
