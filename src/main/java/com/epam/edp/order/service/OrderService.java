package com.epam.edp.order.service;

import com.epam.edp.order.model.OrderModel;
import com.epam.edp.order.model.SimpleMessageModel;

import java.util.List;

public interface OrderService {

    void accept(String msg);

    Integer createFromCart(Integer cartId);

    void postOrderToQueue(Integer orderId);

    List<OrderModel> listAllOrders();

    List<SimpleMessageModel> listAllMessages();
}
