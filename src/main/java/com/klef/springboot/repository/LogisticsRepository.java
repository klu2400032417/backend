package com.klef.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.springboot.entity.LogisticsCoordinator;

public interface LogisticsRepository extends JpaRepository<LogisticsCoordinator, Integer>
{
    LogisticsCoordinator findByEmailAndPassword(String email, String password);
}