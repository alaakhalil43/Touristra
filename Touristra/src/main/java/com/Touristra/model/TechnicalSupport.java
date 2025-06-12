package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "technical_support")
@Data
public class TechnicalSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place assignedPlace;
}