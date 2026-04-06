package com.klef.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.springboot.entity.Recipient;

public interface RecipientRepository extends JpaRepository<Recipient, Integer>
{
	Recipient findByEmail(String email);

	List<Recipient> findByRecipientId(int recipientId);
}
