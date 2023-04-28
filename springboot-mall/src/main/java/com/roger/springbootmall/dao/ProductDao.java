package com.roger.springbootmall.dao;

import com.roger.springbootmall.constant.ProductCategory;
import com.roger.springbootmall.dto.ProductQueryParams;
import com.roger.springbootmall.dto.ProductRequest;
import com.roger.springbootmall.model.Product;

import java.util.List;


public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    void updateStock(Integer productId, Integer stock);
}
