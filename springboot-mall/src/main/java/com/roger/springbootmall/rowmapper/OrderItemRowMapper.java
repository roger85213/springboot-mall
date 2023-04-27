package com.roger.springbootmall.rowmapper;

import com.roger.springbootmall.model.OrderItem;
import com.roger.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper<OrderItem> {

    public OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(resultSet.getInt("oi.order_item_id"));
        orderItem.setOrderId(resultSet.getInt("oi.order_id"));
        orderItem.setProductId(resultSet.getInt("oi.product_id"));
        orderItem.setQuantity(resultSet.getInt("oi.quantity"));
        orderItem.setAmount(resultSet.getInt("oi.amount"));

        //擴充
        orderItem.setProductName(resultSet.getString("p.product_name"));
        orderItem.setImageUrl(resultSet.getString("p.image_url"));

        return orderItem;
    }




    }
