package com.Touristra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "technical_support")
@Data
public class TechnicalSupport extends User {
    private Integer id;
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place assignedPlace;
}