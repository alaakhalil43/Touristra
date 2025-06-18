//package com.Touristra.controllers;
//
//import com.Touristra.model.OrderItem;
//import com.Touristra.dto.SouvenirBookingRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/order-items")
//public class OrderItemController {
//    @Autowired
//    private OrderItemService orderItemService;
//
//    @GetMapping
//    public List<OrderItem> getAll() {
//        return orderItemService.getAllOrderItems();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<OrderItem> getById(@PathVariable Integer id) {
//        return orderItemService.getOrderItemById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public OrderItem create(@RequestBody OrderItem orderItem) {
//        return orderItemService.saveOrderItem(orderItem);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Integer id) {
//        orderItemService.deleteOrderItem(id);
//    }
//
//    @PostMapping("/book-souvenir")
//    public ResponseEntity<OrderItem> bookSouvenir(@RequestBody SouvenirBookingRequest request) {
//        try {
//            OrderItem orderItem = orderItemService.bookSouvenir(
//                request.getOrderId(),
//                request.getSouvenirId(),
//                request.getQuantity(),
//                request.getPrice()
//            );
//            return new ResponseEntity<>(orderItem, HttpStatus.CREATED);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
//}
