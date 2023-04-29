package com.roger.springbootmall.service;

import com.roger.springbootmall.dto.CreateOrderRequest;
import com.roger.springbootmall.dto.OrderQueryParams;
import com.roger.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer createOrder (Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById (Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrders (OrderQueryParams orderQueryParams);

}
