package com.klef.springboot.service;

import java.util.List;

import com.klef.springboot.entity.Admin;
import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.LogisticsCoordinator;
import com.klef.springboot.entity.Recipient;

public interface AdminService {
    
    // Verify admin login by username and password
    Admin verifyAdminLogin(String username, String password);

    // Add a new logistics coordinator
    LogisticsCoordinator addLogisticsCoordinator(LogisticsCoordinator lc);

    // View all logistics coordinators
    List<LogisticsCoordinator> viewAllLogisticsCoordinator();

    // Delete a logistics coordinator by ID
    boolean deleteLogisticsCoordinator(int id);

    // View all recipients
    List<Recipient> viewAllRecipient();

    // View all donors
    List<Donor> viewAllDonor();
}