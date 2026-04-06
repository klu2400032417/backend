package com.klef.springboot.service;

import java.util.List;
import com.klef.springboot.entity.LogisticsCoordinator;
import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.Recipient;

public interface LogisticsService 
{
   // Update pickup schedule
   public String updatePickupSchedule(int id, String pickupDate);

   // Update delivery status (Picked, In Transit, Delivered)
   public String updateDeliveryStatus(int id, String status);

   // Assign driver / transport
   public String assignDriver(int id, String transportType);

   // Update route
   public String updateRoute(int id, String route);

   // Update pickup & delivery locations
   public String updateLocations(int id, String pickup, String delivery);

   // View donors (for pickup handling)
   public List<Donor> viewAllDonors();

   // View recipients (for delivery handling)
   public List<Recipient> viewAllRecipients();
}