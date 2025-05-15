package com.Touristra.repositories;

import com.Touristra.model.Souvenir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SouvenirRepository extends JpaRepository<Souvenir, Integer> {
}
