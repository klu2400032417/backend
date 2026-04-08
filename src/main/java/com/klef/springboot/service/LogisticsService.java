package com.klef.springboot.service;

import java.time.LocalDate;
import java.util.List;

import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.Recipient;
import com.klef.springboot.entity.LogisticsDetails;
import com.klef.springboot.entity.LogisticsCoordinator;

public interface LogisticsService {

    LogisticsCoordinator verifyLogisticsLogin(String email, String password);

    // Update pickup schedule for a logistics entry
    LogisticsDetails updatePickupSchedule(int logisticsId, LocalDate pickupDate);

    // Update delivery status (PENDING, OUT_FOR_DELIVERY, DELIVERED)
    LogisticsDetails updateDeliveryStatus(int logisticsId, String status);

    // Assign driver / transport to a logistics entry
    LogisticsDetails assignDriver(int logisticsId, String transportType, int coordinatorId);

    // Update route assigned to a logistics coordinator
    LogisticsCoordinator updateRoute(int coordinatorId, String route);

    // Update pickup & delivery locations
    LogisticsDetails updateLocations(int logisticsId, String pickupLocation, String deliveryLocation);

    // View all donors (for pickup handling)
    List<Donor> viewAllDonors();

    // View all recipients (for delivery handling)
    List<Recipient> viewAllRecipients();

    // Optional: View all logistics entries
    List<LogisticsDetails> viewAllLogistics();
}