package com.epam.edp.order.controller;

import com.epam.edp.order.model.OrderModel;
import com.epam.edp.order.model.SimpleMessageModel;
import com.epam.edp.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/time")
    public String currentTime() throws UnknownHostException {
        return "time: " +
                Instant.now() +
                " pod: " +
                InetAddress.getLocalHost().getHostName();
    }

    @GetMapping("/orders")
    public List<OrderModel> getAllOrders() {
        return orderService.listAllOrders();
    }

    @PostMapping("/orders")
    public String createOrderFromCart(@RequestParam(name = "cartId") Integer cartId) {
        return "Order " + orderService.createFromCart(cartId) + " created from cart with id " + cartId;
    }

    @GetMapping("/messages")
    public String listAllMessages() {
        List<SimpleMessageModel> messages = orderService.listAllMessages();
        return messages.stream().map(m -> m.getValue()).collect(Collectors.joining(" , "));
    }
}
