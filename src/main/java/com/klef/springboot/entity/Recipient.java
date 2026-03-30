package com.klef.springboot.entity;

	import jakarta.persistence.*;
	import java.time.LocalDate;

	@Entity
	@Table(name = "recipient_table")
	public class Recipient {

	    // Primary Key
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int recipientId;

	    // Basic Info
	    private String name;
	    private String email;
	    private String phoneNumber;
	    private String location;
	    private String role;
	    private String accountStatus;

	    // Request Details
	    private String itemName;
	    private String itemDescription;
	    private int quantity;
	    private String emergencyType;   // Flood / Medical / etc.
	    private String urgencyLevel;    // Low / Medium / High

	    // Tracking
	    private String requestStatus;   // Pending / Approved / Out for Delivery / Delivered
	    private LocalDate expectedDeliveryDate;
	    private LocalDate actualDeliveryDate;

	    // Feedback
	    private int rating; // 1–5
	    private String itemCondition; // Good / Damaged
	    private String feedbackDescription;

	    // Optional
	    private int totalRequests;
	    private int fulfilledRequests;

	    // Getters and Setters

	    public int getRecipientId() {
	        return recipientId;
	    }

	    public void setRecipientId(int recipientId) {
	        this.recipientId = recipientId;
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

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
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

	    public String getEmergencyType() {
	        return emergencyType;
	    }

	    public void setEmergencyType(String emergencyType) {
	        this.emergencyType = emergencyType;
	    }

	    public String getUrgencyLevel() {
	        return urgencyLevel;
	    }

	    public void setUrgencyLevel(String urgencyLevel) {
	        this.urgencyLevel = urgencyLevel;
	    }

	    public String getRequestStatus() {
	        return requestStatus;
	    }

	    public void setRequestStatus(String requestStatus) {
	        this.requestStatus = requestStatus;
	    }

	    public LocalDate getExpectedDeliveryDate() {
	        return expectedDeliveryDate;
	    }

	    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
	        this.expectedDeliveryDate = expectedDeliveryDate;
	    }

	    public LocalDate getActualDeliveryDate() {
	        return actualDeliveryDate;
	    }

	    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
	        this.actualDeliveryDate = actualDeliveryDate;
	    }

	    public int getRating() {
	        return rating;
	    }

	    public void setRating(int rating) {
	        this.rating = rating;
	    }

	    public String getItemCondition() {
	        return itemCondition;
	    }

	    public void setItemCondition(String itemCondition) {
	        this.itemCondition = itemCondition;
	    }

	    public String getFeedbackDescription() {
	        return feedbackDescription;
	    }
	 public void setFeedbackDescription(String feedbackDescription) {
	        this.feedbackDescription = feedbackDescription;
	    }

	    public int getTotalRequests() {
	        return totalRequests;
	    }

	    public void setTotalRequests(int totalRequests) {
	        this.totalRequests = totalRequests;
	    }

	    public int getFulfilledRequests() {
	        return fulfilledRequests;
	    }

	    public void setFulfilledRequests(int fulfilledRequests) {
	        this.fulfilledRequests = fulfilledRequests;
	    }

	    // toString()

	    @Override
	    public String toString() {
	        return "Recipient{" +
	                "recipientId=" + recipientId +
	                ", name='" + name + '\'' +
	                ", email='" + email + '\'' +
	                ", phoneNumber='" + phoneNumber + '\'' +
	                ", location='" + location + '\'' +
	                ", role='" + role + '\'' +
	                ", accountStatus='" + accountStatus + '\'' +
	                ", itemName='" + itemName + '\'' +
	                ", itemDescription='" + itemDescription + '\'' +
	                ", quantity=" + quantity +
	                ", emergencyType='" + emergencyType + '\'' +
	                ", urgencyLevel='" + urgencyLevel + '\'' +
	                ", requestStatus='" + requestStatus + '\'' +
	                ", expectedDeliveryDate=" + expectedDeliveryDate +
	                ", actualDeliveryDate=" + actualDeliveryDate +
	                ", rating=" + rating +
	                ", itemCondition='" + itemCondition + '\'' +
	                ", feedbackDescription='" + feedbackDescription + '\'' +
	                ", totalRequests=" + totalRequests +
	                ", fulfilledRequests=" + fulfilledRequests +
	                '}';
	    }
	}

