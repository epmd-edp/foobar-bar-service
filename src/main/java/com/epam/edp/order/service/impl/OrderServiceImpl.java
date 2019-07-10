package com.epam.edp.order.service.impl;

import com.epam.edp.order.model.OrderModel;
import com.epam.edp.order.model.SimpleMessageModel;
import com.epam.edp.order.repository.OrderRepository;
import com.epam.edp.order.repository.SimpleMessageRepository;
import com.epam.edp.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SimpleMessageRepository simpleMessageRepository;

    @Override
    public void accept(String msg) {
        SimpleMessageModel messageModel = new SimpleMessageModel();
        messageModel.setValue(msg);
        LOG.info("got " + msg);
        simpleMessageRepository.save(messageModel);
    }

    @Override
    public Integer createFromCart(Integer cartId) {
        if (cartId == null) {
            throw new IllegalArgumentException("Cart id cannot be null");
        }
        String cartResponse = restTemplate.getForEntity(
                "http://cart-service:8080/cart-service/carts/" + cartId,
                String.class).getBody();
        String[] array = cartResponse.split("\\|");
        OrderModel orderModel = new OrderModel();
        orderModel.setUserId(Integer.parseInt(array[2]));
        orderModel = orderRepository.save(orderModel);
        return orderModel.getId();
    }

    @Override
    public void postOrderToQueue(Integer orderId) {

    }

    @Override
    public List<OrderModel> listAllOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<SimpleMessageModel> listAllMessages() {
        return StreamSupport.stream(simpleMessageRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
