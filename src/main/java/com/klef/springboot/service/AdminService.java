package com.klef.springboot.service;

import java.util.List;

import com.klef.springboot.entity.Admin;
import com.klef.springboot.entity.Donor;
import com.klef.springboot.entity.LogisticsCoordinator;
import com.klef.springboot.entity.Recipient;

public interface AdminService {
	public Admin verifyAdminLogin(String username,String password);
	  
	  public String addLogisticsCoordinator(LogisticsCoordinator lc);
	  
	  
	  public boolean deleteLogisticsCoordinator(int id);
	  
	  //public List<Donor> getPendingDonations();
	  //public List<Donor> getDeliveredDonations();
	  
	  public List<LogisticsCoordinator> viewAllLogisticsCoordinator();
	  public List<Recipient> viewAllRecipient();
	  public List<Donor> viewAllDonor();
	  
	  
	  
}
