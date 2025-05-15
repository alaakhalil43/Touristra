package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tour_guides")
@Data
public class TourGuide extends User{

    private Integer id;
    private Integer userId;
    private String fullName;
    private String languages;
    private String rating;

    @ManyToMany
    @JoinTable(
            name = "guide_routes",
            joinColumns = @JoinColumn(name = "guide_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )
    private Set<TourRoutes> routes = new HashSet<>();
}