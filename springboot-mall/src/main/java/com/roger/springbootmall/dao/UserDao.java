package com.roger.springbootmall.dao;

import com.roger.springbootmall.dto.UserRegisterRequest;
import com.roger.springbootmall.model.User;

public interface UserDao {

    User getUserId (Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
