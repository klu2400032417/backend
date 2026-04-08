package com.klef.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.springboot.entity.Admin;
import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.LogisticsCoordinator;
import com.klef.springboot.entity.Recipient;
import com.klef.springboot.repository.AdminRepository;
import com.klef.springboot.repository.DonorRepository;
import com.klef.springboot.repository.LogisticsRepository;
import com.klef.springboot.repository.RecipientRepository;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private DonorRepository donorRepository;
    
    @Autowired
    private RecipientRepository recipientRepository;
    
    @Autowired
    private LogisticsRepository logisticsRepository;
    
    @Override
    public Admin verifyAdminLogin(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public LogisticsCoordinator addLogisticsCoordinator(LogisticsCoordinator lc) {
        return logisticsRepository.save(lc);
    }

    @Override
    public List<LogisticsCoordinator> viewAllLogisticsCoordinator() {
        return logisticsRepository.findAll();
    }

    @Override
    public boolean deleteLogisticsCoordinator(int id) {
        if(logisticsRepository.existsById(id)) {
            logisticsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Recipient> viewAllRecipient() {
        return recipientRepository.findAll();
    }

    @Override
    public List<Donor> viewAllDonor() {
        return donorRepository.findAll();
    }
}