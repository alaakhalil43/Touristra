package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "managers")
@Data
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    // Getters and setters
}
