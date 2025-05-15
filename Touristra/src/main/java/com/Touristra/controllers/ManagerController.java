package com.Touristra.controllers;

import com.Touristra.model.Manager;
import com.Touristra.services.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping
    public List<Manager> getAll() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getById(@PathVariable Integer id) {
        return managerService.getManagerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Manager create(@RequestBody Manager manager) {
        return managerService.saveManager(manager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> update(@PathVariable Integer id, @RequestBody Manager manager) {
        if (!managerService.getManagerById(id).isPresent())
            return ResponseEntity.notFound().build();
        manager.setId(id);
        return ResponseEntity.ok(managerService.saveManager(manager));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        managerService.deleteManager(id);
    }
}
