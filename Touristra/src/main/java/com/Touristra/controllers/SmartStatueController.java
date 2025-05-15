package com.Touristra.controllers;

import com.Touristra.model.SmartStatue;
import com.Touristra.services.SmartStatueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/smart-statues")
public class SmartStatueController {
    @Autowired
    private SmartStatueService smartStatueService;

    @GetMapping
    public List<SmartStatue> getAll() {
        return smartStatueService.getAllSmartStatues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmartStatue> getById(@PathVariable Integer id) {
        return smartStatueService.getSmartStatueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SmartStatue create(@RequestBody SmartStatue smartStatue) {
        return smartStatueService.saveSmartStatue(smartStatue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SmartStatue> update(@PathVariable Integer id, @RequestBody SmartStatue smartStatue) {
        if (!smartStatueService.getSmartStatueById(id).isPresent())
            return ResponseEntity.notFound().build();
        smartStatue.setId(id);
        return ResponseEntity.ok(smartStatueService.saveSmartStatue(smartStatue));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        smartStatueService.deleteSmartStatue(id);
    }
}
