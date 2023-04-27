package com.roger.springbootmall.dao;

import com.roger.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems (Integer orderId, List<OrderItem> orderItemList);
}
