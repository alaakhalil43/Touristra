package com.Touristra.services;

import com.Touristra.model.Tourist;
import com.Touristra.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TouristService {
    @Autowired
    private TouristRepository touristRepository;

    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    public Optional<Tourist> getTouristById(Integer id) {
        return touristRepository.findById(id);
    }

    public Tourist saveTourist(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    public void deleteTourist(Integer id) {
        touristRepository.deleteById(id);
    }
}
