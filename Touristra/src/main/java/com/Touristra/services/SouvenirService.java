package com.Touristra.services;

import com.Touristra.model.Souvenir;
import com.Touristra.repositories.SouvenirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SouvenirService {
    @Autowired
    private SouvenirRepository souvenirRepository;

    public List<Souvenir> getAllSouvenirs() {
        return souvenirRepository.findAll();
    }

    public Optional<Souvenir> getSouvenirById(Integer id) {
        return souvenirRepository.findById(id);
    }

    public Souvenir saveSouvenir(Souvenir souvenir) {
        return souvenirRepository.save(souvenir);
    }

    public void deleteSouvenir(Integer id) {
        souvenirRepository.deleteById(id);
    }
}
