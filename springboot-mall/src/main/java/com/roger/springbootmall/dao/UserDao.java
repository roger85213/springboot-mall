package com.roger.springbootmall.dao;

import com.roger.springbootmall.dto.UserLoginRequest;
import com.roger.springbootmall.dto.UserRegisterRequest;
import com.roger.springbootmall.model.OrderItem;
import com.roger.springbootmall.model.User;

import java.util.List;

public interface UserDao {

    User getUserId (Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserByEmail (String email);




}
