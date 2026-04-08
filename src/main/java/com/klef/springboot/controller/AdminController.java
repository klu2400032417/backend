package com.klef.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.springboot.entity.Admin;
import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.LogisticsCoordinator;
import com.klef.springboot.entity.Recipient;
import com.klef.springboot.service.AdminService;

@RestController
@RequestMapping("adminapi")
@CrossOrigin("*")
public class AdminController 
{
    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public String index()
    {
        return "Full Stack SDP Project";
    }

    // ✅ Admin Login
    @PostMapping("/login")
    public ResponseEntity<?> checkadminlogin(@RequestBody Admin admin)
    {
        try
        {
            Admin a = adminService.verifyAdminLogin(admin.getUsername(), admin.getPassword());

            if(a != null)
            {
                return ResponseEntity.ok(a);   // ✅ return actual admin
            }
            else
            {
                return ResponseEntity.status(401).body("Login Invalid");
            }
        }
        catch (Exception e) 
        {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    // ✅ Add Logistics Coordinator (FIXED)
    @PostMapping("/addlogisticcoordinator")
    public ResponseEntity<?> addlogisticcoordinator(@RequestBody LogisticsCoordinator coord)
    {
        try
        {
            LogisticsCoordinator saved = adminService.addLogisticsCoordinator(coord);
            return ResponseEntity.status(201).body(saved);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    // ✅ View All Logistics Coordinators
    @GetMapping("/viewalllogisticscoordinator")
    public ResponseEntity<?> viewalllogisticscoordinator()
    {
        try
        {
            List<LogisticsCoordinator> coord = adminService.viewAllLogisticsCoordinator();
            return ResponseEntity.ok(coord);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Error Fetching Logistic Coordinator");
        }
    }

    // ✅ Delete Logistics Coordinator
    @DeleteMapping("/deletelogisticscoordinator/{id}")
    public ResponseEntity<String> deletelogisticscoordinator(@PathVariable int id)
    {
        try
        {
            boolean deleted = adminService.deleteLogisticsCoordinator(id);

            if(deleted)
            {
                return ResponseEntity.ok("Logistics Coordinator Deleted Successfully");
            }
            else
            {
                return ResponseEntity.status(404).body("Logistics Coordinator Not Found");
            }
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    // ✅ View All Recipients
    @GetMapping("/viewallrecipient")
    public ResponseEntity<?> viewallrecipient()
    {
        try
        {
            List<Recipient> recipients = adminService.viewAllRecipient();
            return ResponseEntity.ok(recipients);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Error Fetching Recipients");
        }
    }

    // ✅ View All Donors
    @GetMapping("/viewalldonor")
    public ResponseEntity<?> viewalldonor()
    {
        try
        {
            List<Donor> donors = adminService.viewAllDonor();
            return ResponseEntity.ok(donors);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Error Fetching Donors");
        }
    }
}