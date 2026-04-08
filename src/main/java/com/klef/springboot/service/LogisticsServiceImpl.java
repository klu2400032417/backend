package com.klef.springboot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.LogisticsCoordinator;
import com.klef.springboot.entity.LogisticsDetails;
import com.klef.springboot.entity.Recipient;
import com.klef.springboot.repository.DonorRepository;
import com.klef.springboot.repository.LogisticsRepository;
import com.klef.springboot.repository.LogisticsDetailsRepository;
import com.klef.springboot.repository.RecipientRepository;

@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired
    private LogisticsDetailsRepository logisticsDetailsRepository;

    @Autowired
    private LogisticsRepository logisticsRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    @Override
    public LogisticsCoordinator verifyLogisticsLogin(String email, String password) {
        return logisticsRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public LogisticsDetails updatePickupSchedule(int logisticsId, LocalDate pickupDate) {
        Optional<LogisticsDetails> opt = logisticsDetailsRepository.findById(logisticsId);
        if (opt.isPresent()) {
            LogisticsDetails logistics = opt.get();
            logistics.setPickupDate(pickupDate);
            return logisticsDetailsRepository.save(logistics);
        }
        return null; // or throw exception as needed
    }

    @Override
    public LogisticsDetails updateDeliveryStatus(int logisticsId, String status) {
        Optional<LogisticsDetails> opt = logisticsDetailsRepository.findById(logisticsId);
        if (opt.isPresent()) {
            LogisticsDetails logistics = opt.get();
            logistics.setDeliveryStatus(status);
            return logisticsDetailsRepository.save(logistics);
        }
        return null;
    }

    @Override
    public LogisticsDetails assignDriver(int logisticsId, String transportType, int coordinatorId) {
        Optional<LogisticsDetails> optLogistics = logisticsDetailsRepository.findById(logisticsId);
        Optional<LogisticsCoordinator> optCoordinator = logisticsRepository.findById(coordinatorId);

        if (optLogistics.isPresent() && optCoordinator.isPresent()) {
            LogisticsDetails logistics = optLogistics.get();
            logistics.setTransportType(transportType);
            // Assuming LogisticsDetails has a reference to coordinator (add if missing)
            // logistics.setCoordinator(optCoordinator.get());
            return logisticsDetailsRepository.save(logistics);
        }
        return null;
    }

    @Override
    public LogisticsCoordinator updateRoute(int coordinatorId, String route) {
        Optional<LogisticsCoordinator> opt = logisticsRepository.findById(coordinatorId);
        if (opt.isPresent()) {
            LogisticsCoordinator coordinator = opt.get();
            coordinator.setAssignedRoute(route);
            return logisticsRepository.save(coordinator);
        }
        return null;
    }

    @Override
    public LogisticsDetails updateLocations(int logisticsId, String pickupLocation, String deliveryLocation) {
        Optional<LogisticsDetails> opt = logisticsDetailsRepository.findById(logisticsId);
        if (opt.isPresent()) {
            LogisticsDetails logistics = opt.get();
            logistics.setPickupLocation(pickupLocation);
            logistics.setDeliveryLocation(deliveryLocation);
            return logisticsDetailsRepository.save(logistics);
        }
        return null;
    }

    @Override
    public List<Donor> viewAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public List<Recipient> viewAllRecipients() {
        return recipientRepository.findAll();
    }

    @Override
    public List<LogisticsDetails> viewAllLogistics() {
        return logisticsDetailsRepository.findAll();
    }
}