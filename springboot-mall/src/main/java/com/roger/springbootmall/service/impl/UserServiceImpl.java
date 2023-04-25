package com.roger.springbootmall.service.impl;

import com.roger.springbootmall.dao.UserDao;
import com.roger.springbootmall.dto.UserRegisterRequest;
import com.roger.springbootmall.model.User;
import com.roger.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User getUserId(Integer userId) {
        return userDao.getUserId(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
