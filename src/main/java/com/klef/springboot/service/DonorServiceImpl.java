package com.klef.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.DonationDetails;
import com.klef.springboot.repository.DonorRepository;
import com.klef.springboot.repository.DonationDetailsRepository;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private DonationDetailsRepository donationRepository;

    // Register
    @Override
    public String donorRegistration(Donor donor) {
        donorRepository.save(donor);
        return "Donor Registered Successfully";
    }

    //  Login
    @Override
    public Donor verifyDonorLogin(String email, String pwd) {
        return donorRepository.findByEmailAndPassword(email, pwd);
    }

    //  Update Profile
    @Override
    public String updateDonorProfile(Donor donor) {
        Optional<Donor> optional = donorRepository.findById(donor.getDonorId());

        if (optional.isPresent()) {
            Donor existing = optional.get();

            existing.setName(donor.getName());
            existing.setEmail(donor.getEmail());
            existing.setPhoneNumber(donor.getPhoneNumber());
            existing.setAddress(donor.getAddress());

            donorRepository.save(existing);
            return "Donor Profile Updated Successfully";
        }

        return "Donor ID Not Found to Update";
    }

    // Add Donation (FIXED)
    @Override
    public String addDonation(DonationDetails donation) {

        int donorId = donation.getDonor().getDonorId();

        Optional<Donor> optional = donorRepository.findById(donorId);

        if (optional.isPresent()) {
            donation.setDonor(optional.get());
            donationRepository.save(donation);
            return "Donation added successfully!";
        }

        return "Donor not found!";
    }

    // View My Donations (FIXED)
    @Override
    public List<DonationDetails> viewMyDonations(int donorId) {
        return donationRepository.findByDonor_DonorId(donorId);
    }

    // Check Delivery Status
    @Override
    public String checkDeliveryStatus(int donorId) {

        List<DonationDetails> donations =
                donationRepository.findByDonor_DonorId(donorId);

        if (donations.isEmpty()) {
            return "No donations found for this donor.";
        }

        StringBuilder statusDetails = new StringBuilder();

        for (DonationDetails d : donations) {
            statusDetails.append("Donation ID: ")
                    .append(d.getDonationId())
                    .append(", Item: ")
                    .append(d.getItemName())
                    .append(", Status: ")
                    .append(d.getDeliveryStatus())
                    .append("\n");
        }

        return statusDetails.toString();
    }
}