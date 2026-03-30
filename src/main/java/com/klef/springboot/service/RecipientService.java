package com.klef.springboot.service;

import java.util.List;

import com.klef.springboot.entity.Recipient;

public interface RecipientService 
{
	public String recipientRegistration(Recipient recipient);
	public Recipient verifyRecipientLogin(String email,String pwd);
	public String updateRecipientProfile(Recipient recipient);
	
	public String requestItem(Recipient recipient);
	public List<Recipient> viewMyRequests(int recipientId);
	
	public String checkRequestStatus(int recipientId);
	public String getExpectedDeliveryDate(int recipientId);
	public String giveFeedback(int recipientId, int rating, String feedback);
}
