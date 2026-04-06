package com.klef.springboot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.springboot.entity.LogisticsCoordinator;
import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.Recipient;
import com.klef.springboot.repository.LogisticsRepository;
import com.klef.springboot.repository.DonorRepository;
import com.klef.springboot.repository.RecipientRepository;

@Service
public class LogisticsServiceImpl implements LogisticsService
{
    @Autowired
    private LogisticsRepository logisticsRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    // ---------------- UPDATE PICKUP ----------------
    @Override
    public String updatePickupSchedule(int id, String pickupDate) 
    {
        Optional<LogisticsCoordinator> obj = logisticsRepository.findById(id);

        if(obj.isPresent())
        {
            LogisticsCoordinator lc = obj.get();
            
            
            LocalDate date = LocalDate.parse(pickupDate);
            lc.setPickupDate(date);

            logisticsRepository.save(lc);
            return "Pickup Schedule Updated Successfully";
        }
        return "Coordinator Not Found";
    }

    // ---------------- UPDATE DELIVERY STATUS ----------------
    @Override
    public String updateDeliveryStatus(int id, String status) 
    {
        Optional<LogisticsCoordinator> obj = logisticsRepository.findById(id);

        if(obj.isPresent())
        {
            LogisticsCoordinator lc = obj.get();
            lc.setDeliveryStatus(status);
            logisticsRepository.save(lc);
            return "Delivery Status Updated Successfully";
        }
        return "Coordinator Not Found";
    }

    // ---------------- ASSIGN DRIVER ----------------
    @Override
    public String assignDriver(int id, String transportType) 
    {
        Optional<LogisticsCoordinator> obj = logisticsRepository.findById(id);

        if(obj.isPresent())
        {
            LogisticsCoordinator lc = obj.get();
            lc.setTransportType(transportType);
            logisticsRepository.save(lc);
            return "Driver Assigned Successfully";
        }
        return "Coordinator Not Found";
    }

    // ---------------- UPDATE ROUTE ----------------
    @Override
    public String updateRoute(int id, String route) 
    {
        Optional<LogisticsCoordinator> obj = logisticsRepository.findById(id);

        if(obj.isPresent())
        {
            LogisticsCoordinator lc = obj.get();
            lc.setAssignedRoute(route);
            logisticsRepository.save(lc);
            return "Route Updated Successfully";
        }
        return "Coordinator Not Found";
    }

    // ---------------- UPDATE LOCATIONS ----------------
    @Override
    public String updateLocations(int id, String pickup, String delivery) 
    {
        Optional<LogisticsCoordinator> obj = logisticsRepository.findById(id);

        if(obj.isPresent())
        {
            LogisticsCoordinator lc = obj.get();
            lc.setPickupLocation(pickup);
            lc.setDeliveryLocation(delivery);
            logisticsRepository.save(lc);
            return "Locations Updated Successfully";
        }
        return "Coordinator Not Found";
    }


    // ---------------- VIEW DONORS ----------------
    @Override
    public List<Donor> viewAllDonors() 
    {
        return donorRepository.findAll();
    }

    // ---------------- VIEW RECIPIENTS ----------------
    @Override
    public List<Recipient> viewAllRecipients() 
    {
        return recipientRepository.findAll();
    }
}