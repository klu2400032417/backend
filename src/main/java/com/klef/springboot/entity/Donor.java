package com.klef.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "donor_table")
public class Donor 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int donorId;

   @Column(length = 50, nullable = false)
   private String name;

   @Column(length = 50, nullable = false, unique = true)
   private String email;
   
   @Column(length = 100, nullable = false)
   private String password;	

   @Column(length = 15)
   private String phoneNumber;

   @Column(length = 100)
   private String address;

   @Column(length = 20)
   private String role; // DONOR

   public int getDonorId() {
	return donorId;
   }

   public void setDonorId(int donorId) {
	this.donorId = donorId;
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

   public String getPassword() {
	return password;
   }

   public void setPassword(String password) {
	this.password = password;
   }

   public String getPhoneNumber() {
	return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
   }

   public String getAddress() {
	return address;
   }

   public void setAddress(String address) {
	this.address = address;
   }

   public String getRole() {
	return role;
   }

   public void setRole(String role) {
	this.role = role;
   }

   @Override
   public String toString() {
	return "Donor [donorId=" + donorId + ", name=" + name + ", email=" + email + ", password=" + password
			+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", role=" + role + "]";
   }

	   
	}