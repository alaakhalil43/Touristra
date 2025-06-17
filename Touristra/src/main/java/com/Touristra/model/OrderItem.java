package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "souvenir_id", nullable = false)
    private SouvenirStore souvenir;

    private Integer quantity;
    private Double price;

    // Getters and setters
}
