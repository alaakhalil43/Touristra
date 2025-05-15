package com.Touristra.services;

import com.Touristra.model.TechnicalSupport;
import com.Touristra.repositories.TechnicalSupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TechnicalSupportService {
    @Autowired
    private TechnicalSupportRepository technicalSupportRepository;

    public List<TechnicalSupport> getAllTechnicalSupports() {
        return technicalSupportRepository.findAll();
    }

    public Optional<TechnicalSupport> getTechnicalSupportById(Integer id) {
        return technicalSupportRepository.findById(id);
    }

    public TechnicalSupport saveTechnicalSupport(TechnicalSupport technicalSupport) {
        return technicalSupportRepository.save(technicalSupport);
    }

    public void deleteTechnicalSupport(Integer id) {
        technicalSupportRepository.deleteById(id);
    }
}
