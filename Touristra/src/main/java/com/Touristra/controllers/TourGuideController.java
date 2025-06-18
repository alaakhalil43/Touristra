package com.Touristra.controllers;

import com.Touristra.model.TourGuide;
import com.Touristra.services.TourGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tour-guides")
public class TourGuideController {
    @Autowired
    private TourGuideService tourGuideService;

    @GetMapping
    public List<TourGuide> getAll() {
        return tourGuideService.getAllTourGuides();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TourGuide> getById(@PathVariable Integer id) {
        return tourGuideService.getTourGuideById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public TourGuide create(@RequestBody TourGuide tourGuide) {
        return tourGuideService.saveTourGuide(tourGuide);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TourGuide> update(@PathVariable Integer id, @RequestBody TourGuide tourGuide) {
        if (!tourGuideService.getTourGuideById(id).isPresent())
            return ResponseEntity.notFound().build();
        tourGuide.setId(id);
        return ResponseEntity.ok(tourGuideService.saveTourGuide(tourGuide));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        tourGuideService.deleteTourGuide(id);
    }
}
