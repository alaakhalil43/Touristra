package com.Touristra.services;

import com.Touristra.model.*;
import com.Touristra.repositories.OrderRepository;
import com.Touristra.repositories.SouvenirStoreRepository;
import com.Touristra.repositories.TourGuideRepository;
import com.Touristra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepo;
    @Autowired private SouvenirStoreRepository productRepo;
    @Autowired private TourGuideRepository tourRepo;
    @Autowired private OrderRepository orderRepo;
    public Order createOrder(OrderRequestDto dto) {

        // 1) التحقق من المستخدم
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found, id=" + dto.getUserId()));

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> items = new ArrayList<>();

        for (OrderItemDto itemDto : dto.getItems()) {

            // حماية من أن يكون المنتَج والرحلة كلاهما أو كلاهما null
            if (itemDto.getProductId() == null && itemDto.getPrivateTourId() == null) {
                throw new IllegalArgumentException(
                        "Each OrderItem must have either productId or privateTourId");
            }

            OrderItem item = new OrderItem();
            item.setOrder(order);   // مهمّ لكسر الدورة العكسية

            /* 2) جلب المنتج أو الرحلة */
            if (itemDto.getProductId() != null) {
                SouvenirStore product = productRepo.findById(itemDto.getProductId())
                        .orElseThrow(() ->
                                new RuntimeException("Product not found, id=" + itemDto.getProductId()));

                item.setSouvenir(product);
                item.setPrice(product.getPrice()); // تأكد أن getPrice() ليس null
            } else {
                TourGuide tour = tourRepo.findById(itemDto.getPrivateTourId())
                        .orElseThrow(() ->
                                new RuntimeException("Tour guide not found, id=" + itemDto.getPrivateTourId()));

                item.setTourGuide(tour);
                item.setPrice((double) tour.getPriceForHour());
            }

            item.setQuantity(itemDto.getQuantity());
            items.add(item);
        }

        order.setOrderItems(items);            // تأكد أن العلاقة عليها cascade = CascadeType.ALL
        return orderRepo.save(order);          // Spring سيرسِل order + items دفعة واحدة
    }
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepo.findByUserId(userId);
    }
}
