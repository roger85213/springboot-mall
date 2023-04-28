package com.roger.springbootmall.service.impl;

import com.roger.springbootmall.dao.OrderDao;
import com.roger.springbootmall.dao.ProductDao;
import com.roger.springbootmall.dao.UserDao;
import com.roger.springbootmall.dto.BuyItem;
import com.roger.springbootmall.dto.CreateOrderRequest;
import com.roger.springbootmall.model.Order;
import com.roger.springbootmall.model.OrderItem;
import com.roger.springbootmall.model.Product;
import com.roger.springbootmall.model.User;
import com.roger.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Transactional//修改多個table時使用，確保同時進行


    //  創建訂單邏輯：先從controller層獲得使用者的訂單資訊，裡面有userId,productId,quantity要傳到order Table裡面的數據只有user Id
    //  ,跟總價錢(利用productId跟quantity算出來),在dao層return利用query找到那比數據的orderId並return,在order_item裡面需要插入的數據
    //  又有orderId,productId,quantity,因此需要先回傳orderId值
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        List<OrderItem> orderItemList = new ArrayList<>();


        User user = userDao.getUserId(userId);
        if (user == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;

        //for循環次數用法:把itemList裡面的值都打印出來,格式為BuyItem
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {

            Product product = productDao.getProductById(buyItem.getProductId());
            //檢查庫存是否足夠
            if (product == null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }else if (product.getStock() < buyItem.getQuantity()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            //扣除庫存 dao層裡的stock參數等於product.getStock() - buyItem.getQuantity()
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());


            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        //插入oder_item裡的數據
        orderDao.createOrderItems(orderId, orderItemList);

            return orderId;

    }

    @Override
    public Order getOrderById(Integer orderId) {

        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemById(orderId);

        //合併，將oderItemList的數據合併到order裏面，需要在Order裡面多創立一個list

        order.setOrderItemList(orderItemList);

        return order;
    }
}
