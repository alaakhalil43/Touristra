package com.Touristra.services;


import com.Touristra.model.Manager;
import com.Touristra.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public List<com.Touristra.model.Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Optional<com.Touristra.model.Manager> getManagerById(Integer id) {
        return managerRepository.findById(id);
    }

    public Manager saveManager(com.Touristra.model.Manager manager) {
        return managerRepository.save(manager);
    }

    public void deleteManager(Integer id) {
        managerRepository.deleteById(id);
    }
}
