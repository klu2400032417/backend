package com.klef.springboot.entity;

import java.time.LocalDate;

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

   @Column(length = 15)
   private String phoneNumber;

   @Column(length = 100)
   private String address;

   @Column(length = 20)
   private String role; // DONOR

   @Column(length = 20)
   private String accountStatus;

   // Donation Details
   @Column(length = 50)
   private String donationCategory;

   @Column(length = 100)
   private String itemName;

   @Column(length = 200)
   private String itemDescription;

   private int quantity;

   @Column(length = 20)
   private String itemcondition;

   private LocalDate availabilityDate; // when item is ready

   private LocalDate expiryDate;

   // Tracking
   private LocalDate pickupScheduleDate;

   @Column(length = 20)
   private String deliveryStatus;

   // Emergency Drives
   @Column(length = 50)
   private String driveId;

   private boolean participatingInDrive;

   // Optional
   private int totalDonationsCount;

   private LocalDate lastDonationDate;

   // Getters and Setters

   public Integer getDonorId() {
      return donorId;
   }

   public void setDonorId(Integer donorId) {
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

   public String getAccountStatus() {
      return accountStatus;
   }

   public void setAccountStatus(String accountStatus) {
      this.accountStatus = accountStatus;
   }

   public String getDonationCategory() {
      return donationCategory;
   }

   public void setDonationCategory(String donationCategory) {
      this.donationCategory = donationCategory;
   }

   public String getItemName() {
      return itemName;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   public String getItemDescription() {
      return itemDescription;
   }

   public void setItemDescription(String itemDescription) {
      this.itemDescription = itemDescription;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String getCondition() {
      return itemcondition;
   }

   public void setCondition(String itemcondition) {
      this.itemcondition = itemcondition;
   }

   public LocalDate getAvailabilityDate() {
      return availabilityDate;
   }

   public void setAvailabilityDate(LocalDate availabilityDate) {
      this.availabilityDate = availabilityDate;
   }

   public LocalDate getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(LocalDate expiryDate) {
      this.expiryDate = expiryDate;
   }

   public LocalDate getPickupScheduleDate() {
      return pickupScheduleDate;
   }

   public void setPickupScheduleDate(LocalDate pickupScheduleDate) {
      this.pickupScheduleDate = pickupScheduleDate;
   }

   public String getDeliveryStatus() {
      return deliveryStatus;
   }

   public void setDeliveryStatus(String deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
   }

   public String getDriveId() {
      return driveId;
   }

   public void setDriveId(String driveId) {
      this.driveId = driveId;
   }

   public boolean isParticipatingInDrive() {
      return participatingInDrive;
   }

   public void setParticipatingInDrive(boolean participatingInDrive) {
      this.participatingInDrive = participatingInDrive;
   }

   public int getTotalDonationsCount() {
      return totalDonationsCount;
   }

   public void setTotalDonationsCount(int totalDonationsCount) {
      this.totalDonationsCount = totalDonationsCount;
   }

   
   public LocalDate getLastDonationDate() {
      return lastDonationDate;
   }

   public void setLastDonationDate(LocalDate lastDonationDate) {
      this.lastDonationDate = lastDonationDate;
   }

   @Override
   public String toString() {
	return "Donor [donorId=" + donorId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
			+ ", address=" + address + ", role=" + role + ", accountStatus=" + accountStatus + ", donationCategory="
			+ donationCategory + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", quantity="
			+ quantity + ", condition=" + itemcondition + ", availabilityDate=" + availabilityDate + ", expiryDate="
			+ expiryDate + ", pickupScheduleDate=" + pickupScheduleDate + ", deliveryStatus=" + deliveryStatus
			+ ", driveId=" + driveId + ", participatingInDrive=" + participatingInDrive + ", totalDonationsCount="
			+ totalDonationsCount + ", lastDonationDate=" + lastDonationDate + ", getDonorId()=" + getDonorId()
			+ ", getName()=" + getName() + ", getEmail()=" + getEmail() + ", getPhoneNumber()=" + getPhoneNumber()
			+ ", getAddress()=" + getAddress() + ", getRole()=" + getRole() + ", getAccountStatus()="
			+ getAccountStatus() + ", getDonationCategory()=" + getDonationCategory() + ", getItemName()="
			+ getItemName() + ", getItemDescription()=" + getItemDescription() + ", getQuantity()=" + getQuantity()
			+ ", getCondition()=" + getCondition() + ", getAvailabilityDate()=" + getAvailabilityDate()
			+ ", getExpiryDate()=" + getExpiryDate() + ", getPickupScheduleDate()=" + getPickupScheduleDate()
			+ ", getDeliveryStatus()=" + getDeliveryStatus() + ", getDriveId()=" + getDriveId()
			+ ", isParticipatingInDrive()=" + isParticipatingInDrive() + ", getTotalDonationsCount()="
			+ getTotalDonationsCount() + ", getLastDonationDate()=" + getLastDonationDate() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
   }

   
}