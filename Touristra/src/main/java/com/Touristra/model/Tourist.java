package com.Touristra.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tourists")
@Data
public class Tourist {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String phone;
        private Integer age;
        private String nationality;
        private String language;


        @ManyToMany
        @JoinTable(name = "tourist_statues", joinColumns = @JoinColumn(name = "tourist_id"), inverseJoinColumns = @JoinColumn(name = "statue_id"))
        private Set<SmartStatue> interactedStatues = new HashSet<>();

        @OneToMany(mappedBy = "tourist")
        private Set<Feedback> feedbacks = new HashSet<>();
}