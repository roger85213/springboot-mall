package com.roger.springbootmall.service.impl;

import com.roger.springbootmall.constant.ProductCategory;
import com.roger.springbootmall.dao.ProductDao;
import com.roger.springbootmall.dto.ProductQueryParams;
import com.roger.springbootmall.dto.ProductRequest;
import com.roger.springbootmall.model.Product;
import com.roger.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProduct(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        return productDao.countProduct(productQueryParams);
    }

    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);

    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }


    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

        productDao.updateProduct(productId,productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {

        productDao.deleteProductById(productId);
    }
}
