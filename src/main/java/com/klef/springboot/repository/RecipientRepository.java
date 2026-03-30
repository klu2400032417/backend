package com.klef.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.springboot.entity.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Integer>{

}
