package com.klef.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.springboot.entity.Recipient;
import com.klef.springboot.service.RecipientService;

@RestController
@RequestMapping("/recipient")
@CrossOrigin
public class RecipientController 
{
   @Autowired
   private RecipientService recipientService;

   // Register
   @PostMapping("/register")
   public String register(@RequestBody Recipient recipient)
   {
      return recipientService.recipientRegistration(recipient);
   }

   // Login
   @PostMapping("/login")
   public Recipient login(@RequestParam String email,
                          @RequestParam String password)
   {
      return recipientService.verifyRecipientLogin(email, password);
   }

   // Update Profile
   @PutMapping("/update")
   public String update(@RequestBody Recipient recipient)
   {
      return recipientService.updateRecipientProfile(recipient);
   }

   // Request Item
   @PostMapping("/request")
   public String requestItem(@RequestBody Recipient recipient)
   {
      return recipientService.requestItem(recipient);
   }

   // View Requests
   @GetMapping("/requests/{id}")
   public List<Recipient> viewRequests(@PathVariable int id)
   {
      return recipientService.viewMyRequests(id);
   }

   // Check Status
   @GetMapping("/status/{id}")
   public String checkStatus(@PathVariable int id)
   {
      return recipientService.checkRequestStatus(id);
   }

   // Delivery Date
   @GetMapping("/delivery/{id}")
   public String getDeliveryDate(@PathVariable int id)
   {
      return recipientService.getExpectedDeliveryDate(id);
   }

   // Feedback
   @PostMapping("/feedback")
   public String feedback(@RequestParam int id,
                          @RequestParam int rating,
                          @RequestParam String feedback)
   {
      return recipientService.giveFeedback(id, rating, feedback);
   }
}