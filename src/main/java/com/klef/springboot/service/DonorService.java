package com.klef.springboot.service;

import java.util.List;

import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.DonationDetails;

public interface DonorService 
{
    public String donorRegistration(Donor donor);

    public Donor verifyDonorLogin(String email, String pwd);

    public String updateDonorProfile(Donor donor);

    public String addDonation(DonationDetails donation);

    public List<DonationDetails> viewMyDonations(int donorId);

    public String checkDeliveryStatus(int donorId);
}