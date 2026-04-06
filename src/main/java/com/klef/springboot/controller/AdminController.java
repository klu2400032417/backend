package com.klef.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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
  
    @PostMapping("/login")
    public ResponseEntity<?> checkadminlogin(@RequestBody Admin admin)
    {
        try
        {
            Admin a = adminService.verifyAdminLogin(admin.getUsername(), admin.getPassword());
    
            if(a!=null)
            {
                return ResponseEntity.status(200).body(admin);
            }
            else
            {
                return ResponseEntity.status(401).body("Login Invalid");
            }
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
  
    @PostMapping("/addlogisticcoordinator")
    public ResponseEntity<String> addlogisticcoordinator(@RequestBody LogisticsCoordinator coord)
    {
        try
        {
            String output = adminService.addLogisticsCoordinator(coord);
            return ResponseEntity.status(201).body(output);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
  
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
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
  
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
            return ResponseEntity.status(500).body("Error Fetching donors");
        }
    }
}