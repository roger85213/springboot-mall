package com.roger.springbootmall.dao;

import com.roger.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
