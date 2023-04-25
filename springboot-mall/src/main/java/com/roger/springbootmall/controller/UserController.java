package com.roger.springbootmall.controller;

import com.roger.springbootmall.dto.UserRegisterRequest;
import com.roger.springbootmall.model.User;
import com.roger.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired

    private UserService userService;

    @PostMapping("/users/register")

    public ResponseEntity<User> register (@RequestBody @Valid UserRegisterRequest userRegisterRequest){

        Integer userId = userService.register(userRegisterRequest);

        User user = userService.getUserId(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);



    }


}
