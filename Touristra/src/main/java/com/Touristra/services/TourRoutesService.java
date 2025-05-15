package com.Touristra.services;

import com.Touristra.model.TourRoutes;
import com.Touristra.repositories.TourRoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TourRoutesService {
    @Autowired
    private TourRoutesRepository tourRoutesRepository;

    public List<TourRoutes> getAllTourRoutes() {
        return tourRoutesRepository.findAll();
    }

    public Optional<TourRoutes> getTourRoutesById(Integer id) {
        return tourRoutesRepository.findById(id);
    }

    public TourRoutes saveTourRoutes(TourRoutes tourRoutes) {
        return tourRoutesRepository.save(tourRoutes);
    }

    public void deleteTourRoutes(Integer id) {
        tourRoutesRepository.deleteById(id);
    }
}
