package com.roger.springbootmall.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CreateOrderRequest {
    //因為前端傳進來的是先有一個buyItemList,在這個list底下才有使用者要買的東西

    @NotEmpty//加在list底下，驗證這個集合裡面一定要有東西
    private List<BuyItem> buyItemList;

    public List<BuyItem> getBuyItemList() {
        return buyItemList;
    }

    public void setBuyItemList(List<BuyItem> buyItemList) {
        this.buyItemList = buyItemList;
    }
}
