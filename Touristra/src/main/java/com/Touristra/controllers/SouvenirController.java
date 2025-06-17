package com.Touristra.controllers;
import com.Touristra.model.SouvenirStore;
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
    public List<SouvenirStore> getAll() {
        return souvenirService.getAllSouvenirs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SouvenirStore> getById(@PathVariable Integer id) {
        return souvenirService.getSouvenirById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SouvenirStore create(@RequestBody SouvenirStore souvenir) {
        return souvenirService.saveSouvenir(souvenir);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        souvenirService.deleteSouvenir(id);
    }
}
