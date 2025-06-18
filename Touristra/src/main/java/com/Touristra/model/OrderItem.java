package com.Touristra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "souvenir_id", nullable = true)
    private SouvenirStore souvenir;

    @ManyToOne
    @JoinColumn(name = "tour_guide_id", nullable = true)
    private TourGuide tourGuide;

    private Integer quantity;
    private Double price;

}
