package com.klef.springboot.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "request_details")
public class RequestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @Column(length = 100, nullable = false)
    private String itemName;

    @Column(length = 200)
    private String itemDescription;

    private int quantity;

    @Column(length = 50)
    private String emergencyType;   // Flood / Medical / etc.

    @Column(length = 20)
    private String urgencyLevel;    // Low / Medium / High

    @Column(length = 20)
    private String requestStatus;   // Pending / Approved / Out for Delivery / Delivered

    // Optional: If the request is linked to a recipient
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    // Optional: If the request is linked to a donation
    @ManyToOne
    @JoinColumn(name = "donation_id")
    private DonationDetails donation;

    // Getters and Setters

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public DonationDetails getDonation() {
        return donation;
    }

    public void setDonation(DonationDetails donation) {
        this.donation = donation;
    }
}