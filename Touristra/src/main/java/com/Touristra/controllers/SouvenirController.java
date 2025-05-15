package com.Touristra.controllers;

import com.Touristra.model.Souvenir;
import com.Touristra.services.SouvenirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/souvenirs")
public class SouvenirController {
    @Autowired
    private SouvenirService souvenirService;

    @GetMapping
    public List<Souvenir> getAll() {
        return souvenirService.getAllSouvenirs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Souvenir> getById(@PathVariable Integer id) {
        return souvenirService.getSouvenirById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Souvenir create(@RequestBody Souvenir souvenir) {
        return souvenirService.saveSouvenir(souvenir);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        souvenirService.deleteSouvenir(id);
    }
}
