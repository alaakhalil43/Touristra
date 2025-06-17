package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

;

@Data
@Entity
public class SouvenirStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Integer stock;


}
