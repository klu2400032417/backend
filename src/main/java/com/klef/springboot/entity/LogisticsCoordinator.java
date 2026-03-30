package com.klef.springboot.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "logistics_coordinator")
public class LogisticsCoordinator {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coordinatorId;

    // Basic Info
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    private String accountStatus;

    // Transport
    private String transportType;
    private String assignedRoute;
    private String pickupLocation;
    private String deliveryLocation;

    // Scheduling
    private LocalDate pickupDate;
    private LocalDate deliveryDate;
    private LocalDateTime estimatedDeliveryTime;

    // Inventory Handling
    
    private List<String> stockItems;

    
    private List<String> categorizedItems;

    private String expiryCheckStatus;
    private String qualityCheckStatus;

    // Delivery
    private String deliveryStatus;
    private String proofOfDelivery;

    // Optional
    private int totalDeliveriesHandled;
    private double onTimeDeliveryRate;

    // Getters and Setters

    public int getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(int coordinatorId) {
        this.coordinatorId = coordinatorId;
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

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getAssignedRoute() {
        return assignedRoute;
    }

    public void setAssignedRoute(String assignedRoute) {
        this.assignedRoute = assignedRoute;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public List<String> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<String> stockItems) {
        this.stockItems = stockItems;
    }

    public List<String> getCategorizedItems() {
        return categorizedItems;
    }

    public void setCategorizedItems(List<String> categorizedItems) {
        this.categorizedItems = categorizedItems;
    }

    public String getExpiryCheckStatus() {
        return expiryCheckStatus;
    }

    public void setExpiryCheckStatus(String expiryCheckStatus) {
        this.expiryCheckStatus = expiryCheckStatus;
    }

    public String getQualityCheckStatus() {
        return qualityCheckStatus;
    }

    public void setQualityCheckStatus(String qualityCheckStatus) {
        this.qualityCheckStatus = qualityCheckStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getProofOfDelivery() {
        return proofOfDelivery;
    }

    public void setProofOfDelivery(String proofOfDelivery) {
        this.proofOfDelivery = proofOfDelivery;
    }

    public int getTotalDeliveriesHandled() {
        return totalDeliveriesHandled;
    }

    public void setTotalDeliveriesHandled(int totalDeliveriesHandled) {
        this.totalDeliveriesHandled = totalDeliveriesHandled;
    }

    public double getOnTimeDeliveryRate() {
        return onTimeDeliveryRate;
    }

    public void setOnTimeDeliveryRate(double onTimeDeliveryRate) {
        this.onTimeDeliveryRate = onTimeDeliveryRate;
    }

    // toString()

    @Override
    public String toString() {
        return "LogisticsCoordinator{" +
                "coordinatorId=" + coordinatorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", transportType='" + transportType + '\'' +
                ", assignedRoute='" + assignedRoute + '\'' +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                ", pickupDate=" + pickupDate +
                ", deliveryDate=" + deliveryDate +
                ", estimatedDeliveryTime=" + estimatedDeliveryTime +
                ", stockItems=" + stockItems +
                ", categorizedItems=" + categorizedItems +
                ", expiryCheckStatus='" + expiryCheckStatus + '\'' +
                ", qualityCheckStatus='" + qualityCheckStatus + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", proofOfDelivery='" + proofOfDelivery + '\'' +
                ", totalDeliveriesHandled=" + totalDeliveriesHandled +
                ", onTimeDeliveryRate=" + onTimeDeliveryRate +
                '}';
    }
}
