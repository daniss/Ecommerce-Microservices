package com.ecommerce.ecommerce.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @PostMapping
    ResponseEntity<String> placeOrder(@RequestBody Order order){
        orderService.placeOrder(order);
        return ResponseEntity.ok("Order placed");
    }
}
