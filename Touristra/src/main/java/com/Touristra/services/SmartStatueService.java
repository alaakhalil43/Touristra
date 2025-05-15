package com.Touristra.services;

import com.Touristra.model.SmartStatue;
import com.Touristra.repositories.SmartStatueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SmartStatueService {
    @Autowired
    private SmartStatueRepository smartStatueRepository;

    public List<SmartStatue> getAllSmartStatues() {
        return smartStatueRepository.findAll();
    }

    public Optional<SmartStatue> getSmartStatueById(Integer id) {
        return smartStatueRepository.findById(id);
    }

    public SmartStatue saveSmartStatue(SmartStatue smartStatue) {
        return smartStatueRepository.save(smartStatue);
    }

    public void deleteSmartStatue(Integer id) {
        smartStatueRepository.deleteById(id);
    }
}
