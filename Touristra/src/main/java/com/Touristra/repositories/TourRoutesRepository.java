package com.Touristra.repositories;

import com.Touristra.model.TourRoutes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRoutesRepository extends JpaRepository<TourRoutes, Integer> {
}