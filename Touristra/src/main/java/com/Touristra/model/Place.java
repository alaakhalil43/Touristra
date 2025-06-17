package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "places")
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String address;
    private String description;

    @OneToMany(mappedBy = "place")
    private Set<SmartStatue> statues = new HashSet<>();

    @OneToMany(mappedBy = "assignedPlace")
    private Set<TechnicalSupport> supportStaff = new HashSet<>();

    @OneToMany(mappedBy = "place")
    private Set<Feedback> feedbacks = new HashSet<>();
}