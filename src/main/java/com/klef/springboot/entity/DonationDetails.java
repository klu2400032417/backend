package com.klef.springboot.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "donation_table")
public class DonationDetails 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donationId;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Donor donor;

    @Column(length = 50)
    private String donationCategory;

    @Column(length = 100)
    private String itemName;

    @Column(length = 200)
    private String itemDescription;

    private int quantity;

    @Column(name = "item_condition", length = 20)
    private String itemCondition;

    private LocalDate availabilityDate;
    private LocalDate expiryDate;
    private LocalDate pickupScheduleDate;

    @Column(length = 20)
    private String deliveryStatus;

    @Column(length = 50)
    private String driveId;

    private boolean participatingInDrive;

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
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

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
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

	@Override
	public String toString() {
		return "DonationDetails [donationId=" + donationId + ", donor=" + donor + ", donationCategory="
				+ donationCategory + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", quantity="
				+ quantity + ", itemCondition=" + itemCondition + ", availabilityDate=" + availabilityDate
				+ ", expiryDate=" + expiryDate + ", pickupScheduleDate=" + pickupScheduleDate + ", deliveryStatus="
				+ deliveryStatus + ", driveId=" + driveId + ", participatingInDrive=" + participatingInDrive + "]";
	}
}