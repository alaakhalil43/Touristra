package com.Touristra.services;
import com.Touristra.model.SouvenirStore;
import com.Touristra.repositories.SouvenirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SouvenirService {
    @Autowired
    private SouvenirRepository souvenirRepository;

    public List<SouvenirStore> getAllSouvenirs() {
        return souvenirRepository.findAll();
    }

    public Optional<SouvenirStore> getSouvenirById(Integer id) {
        return souvenirRepository.findById(id);
    }

    public SouvenirStore saveSouvenir(SouvenirStore souvenir) {
        return souvenirRepository.save(souvenir);
    }

    public void deleteSouvenir(Integer id) {
        souvenirRepository.deleteById(id);
    }
}
