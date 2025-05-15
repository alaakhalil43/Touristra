package com.Touristra.controllers;

import com.Touristra.model.Tourist;
import com.Touristra.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {
    @Autowired
    private TouristService touristService;

    @GetMapping
    public List<Tourist> getAll() {
        return touristService.getAllTourists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tourist> getById(@PathVariable Integer id) {
        return touristService.getTouristById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tourist create(@RequestBody Tourist tourist) {
        return touristService.saveTourist(tourist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tourist> update(@PathVariable Integer id, @RequestBody Tourist tourist) {
        if (!touristService.getTouristById(id).isPresent())
            return ResponseEntity.notFound().build();
        tourist.setId(id);
        return ResponseEntity.ok(touristService.saveTourist(tourist));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        touristService.deleteTourist(id);
    }
}
