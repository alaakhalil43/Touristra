package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "smart_statues")
@Data
public class SmartStatue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private String longitude;

    @Column(nullable = false)
    private String latitude;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @ManyToMany(mappedBy = "interactedStatues")
    private Set<Tourist> tourists = new HashSet<>();
}