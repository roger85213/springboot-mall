package com.roger.springbootmall.service;

import com.roger.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder (Integer userId, CreateOrderRequest createOrderRequest);
}
