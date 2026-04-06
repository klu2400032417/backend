package com.klef.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.springboot.entity.DonationDetails;

public interface DonationDetailsRepository extends JpaRepository<DonationDetails, Integer> 
{
   // Correct mapping
   List<DonationDetails> findByDonor_DonorId(int donorId);

   // Works fine
   List<DonationDetails> findByDeliveryStatus(String status);
}