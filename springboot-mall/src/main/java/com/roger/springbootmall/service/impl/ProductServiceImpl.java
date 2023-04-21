package com.roger.springbootmall.service.impl;

import com.roger.springbootmall.dao.ProductDao;
import com.roger.springbootmall.model.Product;
import com.roger.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);

    }
}
