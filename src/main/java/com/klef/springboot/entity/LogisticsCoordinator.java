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
   private String password;
   private String assignedRoute;
   public int getId() {
	return id;
   }
   public void setId(int id) {
	this.id = id;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public String getEmail() {
	return email;
   }
   public void setEmail(String email) {
	this.email = email;
   }
   public String getPhoneNumber() {
	return phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
   }
   public String getPassword() {
	return password;
   }
   public void setPassword(String password) {
	this.password = password;
   }
   
   public String getAssignedRoute() {
	return assignedRoute;
   }
   public void setAssignedRoute(String assignedRoute) {
	this.assignedRoute = assignedRoute;
   }

  

   // Getters and Setters

 
  
}