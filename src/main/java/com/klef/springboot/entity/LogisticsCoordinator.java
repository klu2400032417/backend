package com.klef.springboot.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "logistics_table")
public class LogisticsCoordinator 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private String name;
   private String email;
   private String phoneNumber;

   private String transportType;
   private String assignedRoute;

   private String pickupLocation;
   private String deliveryLocation;

   private LocalDate pickupDate;
   private LocalDate deliveryDate;

   private String deliveryStatus;

   // Getters and Setters

   public int getId() { return id; }
   public void setId(int id) { this.id = id; }

   public String getName() { return name; }
   public void setName(String name) { this.name = name; }

   public String getEmail() { return email; }
   public void setEmail(String email) { this.email = email; }

   public String getPhoneNumber() { return phoneNumber; }
   public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

   public String getTransportType() { return transportType; }
   public void setTransportType(String transportType) { this.transportType = transportType; }

   public String getAssignedRoute() { return assignedRoute; }
   public void setAssignedRoute(String assignedRoute) { this.assignedRoute = assignedRoute; }

   public String getPickupLocation() { return pickupLocation; }
   public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }

   public String getDeliveryLocation() { return deliveryLocation; }
   public void setDeliveryLocation(String deliveryLocation) { this.deliveryLocation = deliveryLocation; }

   public LocalDate getPickupDate() { return pickupDate; }
   public void setPickupDate(LocalDate pickupDate) { this.pickupDate = pickupDate; }

   public LocalDate getDeliveryDate() { return deliveryDate; }
   public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }

   public String getDeliveryStatus() { return deliveryStatus; }
   public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }
}