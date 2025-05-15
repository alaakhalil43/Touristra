package com.Touristra.services;

import com.Touristra.model.TourGuide;
import com.Touristra.repositories.TourGuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TourGuideService {
    @Autowired
    private TourGuideRepository tourGuideRepository;

    public List<TourGuide> getAllTourGuides() {
        return tourGuideRepository.findAll();
    }

    public Optional<TourGuide> getTourGuideById(Integer id) {
        return tourGuideRepository.findById(id);
    }

    public TourGuide saveTourGuide(TourGuide tourGuide) {
        return tourGuideRepository.save(tourGuide);
    }

    public void deleteTourGuide(Integer id) {
        tourGuideRepository.deleteById(id);
    }
}
