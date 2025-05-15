package com.Touristra.controllers;

import com.Touristra.model.TourRoutes;
import com.Touristra.services.TourRoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tour-routes")
public class TourRoutesController {
    @Autowired
    private TourRoutesService tourRoutesService;

    @GetMapping
    public List<TourRoutes> getAll() {
        return tourRoutesService.getAllTourRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourRoutes> getById(@PathVariable Integer id) {
        return tourRoutesService.getTourRoutesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TourRoutes create(@RequestBody TourRoutes tourRoutes) {
        return tourRoutesService.saveTourRoutes(tourRoutes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourRoutes> update(@PathVariable Integer id, @RequestBody TourRoutes tourRoutes) {
        if (!tourRoutesService.getTourRoutesById(id).isPresent())
            return ResponseEntity.notFound().build();
        tourRoutes.setId(id);
        return ResponseEntity.ok(tourRoutesService.saveTourRoutes(tourRoutes));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        tourRoutesService.deleteTourRoutes(id);
    }
}
