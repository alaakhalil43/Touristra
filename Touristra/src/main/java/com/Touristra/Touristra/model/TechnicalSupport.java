package com.Touristra.Touristra.model;

import com.Touristra.Touristra.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "technical_support")
@Data
public class TechnicalSupport extends User {
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place assignedPlace;
}