package com.klef.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/register")
    public String registerDonor(@RequestBody Donor donor) {
        return donorService.donorRegistration(donor);
    }

    @PostMapping("/login")
    public Donor loginDonor(@RequestParam String email,
                            @RequestParam String pwd) {
        return donorService.verifyDonorLogin(email, pwd);
    }

    @PutMapping("/update")
    public String updateProfile(@RequestBody Donor donor) {
        return donorService.updateDonorProfile(donor);
    }

    // ------------------ DONATION ------------------

    @PostMapping("/addDonation")
    public String addDonation(@RequestBody DonationDetails donation) {
        return donorService.addDonation(donation);
    }

    @GetMapping("/myDonations/{donorId}")
    public List<DonationDetails> viewMyDonations(@PathVariable int donorId) {
        return donorService.viewMyDonations(donorId);
    }

    @GetMapping("/deliveryStatus/{donorId}")
    public String checkDeliveryStatus(@PathVariable int donorId) {
        return donorService.checkDeliveryStatus(donorId);
    }
}