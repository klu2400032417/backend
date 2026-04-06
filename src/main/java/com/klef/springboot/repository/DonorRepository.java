package com.klef.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.springboot.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Integer>{
   Donor findByEmailAndPassword(String email, String password);
}