package com.Touristra.controllers;

import com.Touristra.model.Order;
import com.Touristra.model.OrderRequestDto;
import com.Touristra.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequestDto dto) {
        return ResponseEntity.ok(orderService.createOrder(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Integer userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }
}
