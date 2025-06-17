package com.Touristra.repositories;

import com.Touristra.model.SouvenirStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SouvenirRepository extends JpaRepository<SouvenirStore, Integer> {
}
