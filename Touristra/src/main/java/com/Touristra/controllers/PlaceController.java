package com.Touristra.controllers;

import com.Touristra.model.Place;
import com.Touristra.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAll() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getById(@PathVariable Integer id) {
        return placeService.getPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Place create(@RequestBody Place place) {
        return placeService.savePlace(place);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> update(@PathVariable Integer id, @RequestBody Place place) {
        if (!placeService.getPlaceById(id).isPresent())
            return ResponseEntity.notFound().build();
        place.setId(id);
        return ResponseEntity.ok(placeService.savePlace(place));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        placeService.deletePlace(id);
    }
}
