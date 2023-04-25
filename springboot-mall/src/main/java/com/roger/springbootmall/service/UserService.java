package com.roger.springbootmall.service;

import com.roger.springbootmall.dto.UserRegisterRequest;
import com.roger.springbootmall.model.User;

public interface UserService {

    User getUserId (Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
