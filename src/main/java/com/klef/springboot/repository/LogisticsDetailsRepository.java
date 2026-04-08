package com.klef.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.springboot.entity.LogisticsDetails;

public interface LogisticsDetailsRepository extends JpaRepository<LogisticsDetails, Integer> {
    // No need to declare findById; it's inherited from JpaRepository
}