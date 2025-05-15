package com.Touristra.repositories;

import com.Touristra.model.SmartStatue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartStatueRepository extends JpaRepository<SmartStatue, Integer> {
}