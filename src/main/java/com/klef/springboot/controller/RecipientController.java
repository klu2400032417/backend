package com.klef.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.springboot.entity.Recipient;
import com.klef.springboot.entity.RequestDetails;
import com.klef.springboot.service.RecipientService;

@RestController
@RequestMapping("/recipient")
@CrossOrigin("*")
public class RecipientController 
{
   @Autowired
   private RecipientService recipientService;

   // ✅ Register
   @PostMapping("/register")
   public ResponseEntity<String> register(@RequestBody Recipient recipient)
   {
      return ResponseEntity.ok(recipientService.recipientRegistration(recipient));
   }

   // ✅ Login (FIXED)
   @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody Recipient recipient)
   {
      Recipient r = recipientService.verifyRecipientLogin(
            recipient.getEmail(), recipient.getPassword());

      if(r != null)
         return ResponseEntity.ok(r);
      else
         return ResponseEntity.status(401).body("Invalid Login");
   }

   // ✅ Update Profile
   @PutMapping("/update")
   public ResponseEntity<String> update(@RequestBody Recipient recipient)
   {
      return ResponseEntity.ok(recipientService.updateRecipientProfile(recipient));
   }

   // ✅ Request Item (FIXED 🔥)
   @PostMapping("/request")
   public ResponseEntity<String> requestItem(@RequestBody RequestDetails request)
   {
      return ResponseEntity.ok(recipientService.requestItem(request));
   }

   // ✅ View Requests (FIXED 🔥)
   @GetMapping("/requests/{id}")
   public ResponseEntity<List<RequestDetails>> viewRequests(@PathVariable int id)
   {
      return ResponseEntity.ok(recipientService.viewMyRequests(id));
   }

   // ✅ Check Status
   @GetMapping("/status/{id}")
   public ResponseEntity<String> checkStatus(@PathVariable int id)
   {
      return ResponseEntity.ok(recipientService.checkRequestStatus(id));
   }

   // ✅ Delivery Date
   @GetMapping("/delivery/{id}")
   public ResponseEntity<String> getDeliveryDate(@PathVariable int id)
   {
      return ResponseEntity.ok(recipientService.getExpectedDeliveryDate(id));
   }

   // ✅ Feedback (FIXED)
   @PostMapping("/feedback")
   public ResponseEntity<String> feedback(@RequestParam int id,
                                          @RequestParam int rating,
                                          @RequestParam String feedback)
   {
      return ResponseEntity.ok(
            recipientService.giveFeedback(id, rating, feedback));
   }
}