package com.Touristra.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TourRoutes")
@Data
public class TourRoutes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "start_point", nullable = false)
    private String startPoint;

    @Column(name = "end_point", nullable = false)
    private String endPoint;
    private String description;

    @ManyToMany(mappedBy = "routes")
    private Set<Tourist> tourists = new HashSet<>();

    @ManyToMany(mappedBy = "routes")
    private Set<TourGuide> guides = new HashSet<>();
}