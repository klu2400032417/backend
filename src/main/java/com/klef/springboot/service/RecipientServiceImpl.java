package com.klef.springboot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.springboot.entity.Recipient;
import com.klef.springboot.repository.RecipientRepository;

@Service
public class RecipientServiceImpl implements RecipientService
{
   @Autowired
   private RecipientRepository recipientRepository;

   @Override
   public String recipientRegistration(Recipient recipient) 
   {
      recipient.setRole("RECIPIENT");
      recipient.setAccountStatus("Active");
      recipientRepository.save(recipient);
      return "Recipient Registered Successfully";
   }

   @Override
   public Recipient verifyRecipientLogin(String email, String pwd) 
   {
      // password not in entity → ignore pwd
      return recipientRepository.findByEmail(email);
   }

   @Override
   public String updateRecipientProfile(Recipient recipient) 
   {
      recipientRepository.save(recipient);
      return "Profile Updated Successfully";
   }

   @Override
   public String requestItem(Recipient recipient) 
   {
      recipient.setRequestStatus("Pending");
      recipient.setExpectedDeliveryDate(LocalDate.now().plusDays(3));
      recipientRepository.save(recipient);
      return "Request Submitted Successfully";
   }

   @Override
   public List<Recipient> viewMyRequests(int recipientId) 
   {
      return recipientRepository.findByRecipientId(recipientId);
   }

   @Override
   public String checkRequestStatus(int recipientId) 
   {
      Recipient r = recipientRepository.findById(recipientId).orElse(null);
      if(r != null)
      {
         return r.getRequestStatus();
      }
      return "No Request Found";
   }

   @Override
   public String getExpectedDeliveryDate(int recipientId) 
   {
      Recipient r = recipientRepository.findById(recipientId).orElse(null);
      if(r != null && r.getExpectedDeliveryDate() != null)
      {
         return r.getExpectedDeliveryDate().toString();
      }
      return "No Delivery Date Available";
   }

   @Override
   public String giveFeedback(int recipientId, int rating, String feedback) 
   {
      Recipient r = recipientRepository.findById(recipientId).orElse(null);
      if(r != null)
      {
         r.setRating(rating);
         r.setFeedbackDescription(feedback);
         r.setItemCondition("Good");
         recipientRepository.save(r);
         return "Feedback Submitted Successfully";
      }
      return "Recipient Not Found";
   }
}