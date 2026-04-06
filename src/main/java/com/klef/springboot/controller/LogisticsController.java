package com.klef.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.Recipient;
import com.klef.springboot.service.LogisticsService;

@RestController
@RequestMapping("logisticsapi")
@CrossOrigin("*")
public class LogisticsController 
{
   @Autowired
   private LogisticsService logisticsService;

   // ---------------- UPDATE PICKUP ----------------
   @PutMapping("/updatepickupschedule/{id}/{date}")
   public ResponseEntity<String> updatePickup(
         @PathVariable int id,
         @PathVariable String date)
   {
      try
      {
         String output = logisticsService.updatePickupSchedule(id, date);
         return ResponseEntity.ok(output);
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Updating Pickup");
      }
   }

   // ---------------- UPDATE DELIVERY STATUS ----------------
   @PutMapping("/updatedeliverystatus/{id}/{status}")
   public ResponseEntity<String> updateStatus(
         @PathVariable int id,
         @PathVariable String status)
   {
      try
      {
         String output = logisticsService.updateDeliveryStatus(id, status);
         return ResponseEntity.ok(output);
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Updating Status");
      }
   }

   // ---------------- ASSIGN DRIVER ----------------
   @PutMapping("/assigndriver/{id}/{transport}")
   public ResponseEntity<String> assignDriver(
         @PathVariable int id,
         @PathVariable String transport)
   {
      try
      {
         String output = logisticsService.assignDriver(id, transport);
         return ResponseEntity.ok(output);
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Assigning Driver");
      }
   }

   // ---------------- UPDATE ROUTE ----------------
   @PutMapping("/updateroute/{id}/{route}")
   public ResponseEntity<String> updateRoute(
         @PathVariable int id,
         @PathVariable String route)
   {
      try
      {
         String output = logisticsService.updateRoute(id, route);
         return ResponseEntity.ok(output);
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Updating Route");
      }
   }

   // ---------------- UPDATE LOCATIONS ----------------
   @PutMapping("/updatelocations/{id}")
   public ResponseEntity<String> updateLocations(
         @PathVariable int id,
         @RequestParam String pickup,
         @RequestParam String delivery)
   {
      try
      {
         String output = logisticsService.updateLocations(id, pickup, delivery);
         return ResponseEntity.ok(output);
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Updating Locations");
      }
   }

   // ---------------- VIEW DONORS ----------------
   @GetMapping("/viewdonors")
   public ResponseEntity<?> viewDonors()
   {
      try
      {
         List<Donor> donors = logisticsService.viewAllDonors();
         return ResponseEntity.ok(donors);
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Fetching Donors");
      }
   }

   // ---------------- VIEW RECIPIENTS ----------------
   @GetMapping("/viewrecipients")
   public ResponseEntity<?> viewRecipients()
   {
      try
      {
         List<Recipient> recipients = logisticsService.viewAllRecipients();
         return ResponseEntity.ok(recipients);
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Fetching Recipients");
      }
   }
}