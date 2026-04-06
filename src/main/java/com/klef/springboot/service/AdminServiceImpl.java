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
public class AdminServiceImpl implements AdminService
{
  @Autowired
  private AdminRepository adminRepository;
  
  @Autowired
  private DonorRepository donorRepository;
  
  @Autowired
  private RecipientRepository recipientRepository;
  
  @Autowired
  private LogisticsRepository logisticsRepository;
  
  
  @Override
  public Admin verifyAdminLogin(String username, String password) 
  {
    return adminRepository.findByUsernameAndPassword(username, password);
  }

  @Override
  public String addLogisticsCoordinator(LogisticsCoordinator lc) 
  {
    logisticsRepository.save(lc);
    return "Logistics Coordinator Added Successfully";
  }

  @Override
  public List<LogisticsCoordinator> viewAllLogisticsCoordinator() {
    // TODO Auto-generated method stub
    return logisticsRepository.findAll();
  }

  @Override
  public boolean deleteLogisticsCoordinator(int id) {
    // TODO Auto-generated method stub
    if(logisticsRepository.existsById(id))
    {
      logisticsRepository.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public List<Recipient> viewAllRecipient() {
    // TODO Auto-generated method stub
    return recipientRepository.findAll();
  }

  @Override
  public List<Donor> viewAllDonor() {
    // TODO Auto-generated method stub
    return donorRepository.findAll();
  }
  
}