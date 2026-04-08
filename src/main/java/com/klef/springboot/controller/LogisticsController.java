package com.klef.springboot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.LogisticsCoordinator;
import com.klef.springboot.entity.LogisticsDetails;
import com.klef.springboot.entity.Recipient;
import com.klef.springboot.service.LogisticsService;

@RestController
@RequestMapping("logisticsapi")
@CrossOrigin("*")
public class LogisticsController 
{
   @Autowired
   private LogisticsService logisticsService;

   @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody LogisticsCoordinator coordinator)
   {
      LogisticsCoordinator data = logisticsService.verifyLogisticsLogin(
            coordinator.getEmail(), coordinator.getPassword());

      if (data != null) {
         return ResponseEntity.ok(data);
      }
      return ResponseEntity.status(401).body("Invalid Email or Password");
   }

   // ✅ UPDATE PICKUP
   @PutMapping("/updatepickupschedule/{id}/{date}")
   public ResponseEntity<?> updatePickup(
         @PathVariable int id,
         @PathVariable String date)
   {
      try
      {
         LocalDate pickupDate = LocalDate.parse(date);
         LogisticsDetails result = logisticsService.updatePickupSchedule(id, pickupDate);

         return (result != null) ? ResponseEntity.ok(result)
                                : ResponseEntity.status(404).body("Logistics Not Found");
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Updating Pickup");
      }
   }

   // ✅ UPDATE DELIVERY STATUS
   @PutMapping("/updatedeliverystatus/{id}/{status}")
   public ResponseEntity<?> updateStatus(
         @PathVariable int id,
         @PathVariable String status)
   {
      try
      {
         LogisticsDetails result = logisticsService.updateDeliveryStatus(id, status);

         return (result != null) ? ResponseEntity.ok(result)
                                : ResponseEntity.status(404).body("Logistics Not Found");
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Updating Status");
      }
   }

   // ✅ ASSIGN DRIVER (FIXED 🔥)
   @PutMapping("/assigndriver/{logisticsId}/{transport}/{coordinatorId}")
   public ResponseEntity<?> assignDriver(
         @PathVariable int logisticsId,
         @PathVariable String transport,
         @PathVariable int coordinatorId)
   {
      try
      {
         LogisticsDetails result = logisticsService.assignDriver(logisticsId, transport, coordinatorId);

         return (result != null) ? ResponseEntity.ok(result)
                                : ResponseEntity.status(404).body("Data Not Found");
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Assigning Driver");
      }
   }

   // ✅ UPDATE ROUTE
   @PutMapping("/updateroute/{id}/{route}")
   public ResponseEntity<?> updateRoute(
         @PathVariable int id,
         @PathVariable String route)
   {
      try
      {
         LogisticsCoordinator result = logisticsService.updateRoute(id, route);

         return (result != null) ? ResponseEntity.ok(result)
                                : ResponseEntity.status(404).body("Coordinator Not Found");
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Updating Route");
      }
   }

   // ✅ UPDATE LOCATIONS
   @PutMapping("/updatelocations/{id}")
   public ResponseEntity<?> updateLocations(
         @PathVariable int id,
         @RequestParam String pickup,
         @RequestParam String delivery)
   {
      try
      {
         LogisticsDetails result = logisticsService.updateLocations(id, pickup, delivery);

         return (result != null) ? ResponseEntity.ok(result)
                                : ResponseEntity.status(404).body("Logistics Not Found");
      }
      catch(Exception e)
      {
         return ResponseEntity.status(500).body("Error Updating Locations");
      }
   }

   // ✅ VIEW DONORS
   @GetMapping("/viewdonors")
   public ResponseEntity<List<Donor>> viewDonors()
   {
      return ResponseEntity.ok(logisticsService.viewAllDonors());
   }

   // ✅ VIEW RECIPIENTS
   @GetMapping("/viewrecipients")
   public ResponseEntity<List<Recipient>> viewRecipients()
   {
      return ResponseEntity.ok(logisticsService.viewAllRecipients());
   }

   // ✅ VIEW ALL LOGISTICS
   @GetMapping("/viewalllogistics")
   public ResponseEntity<List<LogisticsDetails>> viewAllLogistics()
   {
      return ResponseEntity.ok(logisticsService.viewAllLogistics());
   }
}