package com.roger.springbootmall.dto;

import javax.validation.constraints.NotNull;

public class BuyItem {

    //在buyItemList底下的兩個key

    @NotNull
    private Integer productId;
    @NotNull
    private Integer quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
