package com.Touristra.controllers;

import com.Touristra.model.TechnicalSupport;
import com.Touristra.services.TechnicalSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/technical-support")
public class TechnicalSupportController {
    @Autowired
    private TechnicalSupportService technicalSupportService;

    @GetMapping
    public List<TechnicalSupport> getAll() {
        return technicalSupportService.getAllTechnicalSupports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicalSupport> getById(@PathVariable Integer id) {
        return technicalSupportService.getTechnicalSupportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TechnicalSupport create(@RequestBody TechnicalSupport technicalSupport) {
        return technicalSupportService.saveTechnicalSupport(technicalSupport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicalSupport> update(@PathVariable Integer id,
            @RequestBody TechnicalSupport technicalSupport) {
        if (!technicalSupportService.getTechnicalSupportById(id).isPresent())
            return ResponseEntity.notFound().build();
        technicalSupport.setId(id);
        return ResponseEntity.ok(technicalSupportService.saveTechnicalSupport(technicalSupport));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        technicalSupportService.deleteTechnicalSupport(id);
    }
}
