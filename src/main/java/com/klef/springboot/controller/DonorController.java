package com.klef.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.DonationDetails;
import com.klef.springboot.service.DonorService;

@RestController
@RequestMapping("/donorapi")
@CrossOrigin("*")
public class DonorController {

    @Autowired
    private DonorService donorService;

    // ------------------ DONOR ------------------

    // ✅ Register
    @PostMapping("/register")
    public ResponseEntity<String> registerDonor(@RequestBody Donor donor) {
        String msg = donorService.donorRegistration(donor);
        return ResponseEntity.ok(msg);
    }

    // ✅ Login (FIXED)
    @PostMapping("/login")
    public ResponseEntity<?> loginDonor(@RequestBody Donor donor) {
        Donor d = donorService.verifyDonorLogin(donor.getEmail(), donor.getPassword());

        if (d != null) {
            return ResponseEntity.ok(d);
        } else {
            return ResponseEntity.status(401).body("Invalid Email or Password");
        }
    }

    // ✅ Update Profile
    @PutMapping("/update")
    public ResponseEntity<String> updateProfile(@RequestBody Donor donor) {
        String msg = donorService.updateDonorProfile(donor);
        return ResponseEntity.ok(msg);
    }

    // ------------------ DONATION ------------------

    // ✅ Add Donation
    @PostMapping("/addDonation")
    public ResponseEntity<String> addDonation(@RequestBody DonationDetails donation) {
        String msg = donorService.addDonation(donation);
        return ResponseEntity.ok(msg);
    }

    // ✅ View My Donations
    @GetMapping("/myDonations/{donorId}")
    public ResponseEntity<List<DonationDetails>> viewMyDonations(@PathVariable int donorId) {
        return ResponseEntity.ok(donorService.viewMyDonations(donorId));
    }

    // ✅ Check Delivery Status
    @GetMapping("/deliveryStatus/{donorId}")
    public ResponseEntity<String> checkDeliveryStatus(@PathVariable int donorId) {
        return ResponseEntity.ok(donorService.checkDeliveryStatus(donorId));
    }
}