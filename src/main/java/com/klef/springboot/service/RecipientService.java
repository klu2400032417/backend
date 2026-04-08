package com.klef.springboot.service;

import java.util.List;

import com.klef.springboot.entity.Recipient;
import com.klef.springboot.entity.RequestDetails;

public interface RecipientService 
{
    public String recipientRegistration(Recipient recipient);

    public Recipient verifyRecipientLogin(String email, String pwd);

    public String updateRecipientProfile(Recipient recipient);

    public String requestItem(RequestDetails request);

    public List<RequestDetails> viewMyRequests(int recipientId);

    public String checkRequestStatus(int requestId);

    public String getExpectedDeliveryDate(int requestId);

    public String giveFeedback(int requestId, int rating, String feedback);
}