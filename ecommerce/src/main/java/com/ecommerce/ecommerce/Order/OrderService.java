package com.ecommerce.ecommerce.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void placeOrder(Order order){
        orderRepository.save(order);
    }
}
