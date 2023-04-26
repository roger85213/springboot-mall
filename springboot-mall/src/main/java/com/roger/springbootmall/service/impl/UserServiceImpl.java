package com.roger.springbootmall.service.impl;

import com.roger.springbootmall.dao.UserDao;
import com.roger.springbootmall.dto.UserLoginRequest;
import com.roger.springbootmall.dto.UserRegisterRequest;
import com.roger.springbootmall.model.User;
import com.roger.springbootmall.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@Component
public class UserServiceImpl implements UserService {
    //private final static Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserDao userDao;


    @Override
    public User getUserId(Integer userId) {
        return userDao.getUserId(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        //從前端傳來的值裡面的email變數
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        //如果查到就噴exception
        if (user != null){
            //log.warn("該email{}已被註冊",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //使用MD5生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);

        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        //檢查user是否存在
        if (user == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        String hashPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());

        if (user.getPassword().equals(hashPassword)){

            return user;
        }else {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
