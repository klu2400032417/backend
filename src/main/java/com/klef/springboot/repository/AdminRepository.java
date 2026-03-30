package com.klef.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.springboot.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,String> {
	   public Admin findByUsernameAndPassword(String username, String password);
}
