package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tour_guides")
@Data
public class TourGuide{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String image;
    private Integer priceForHour;
    private String languages;
    private String rating;
}