package com.klef.springboot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.springboot.entity.Recipient;
import com.klef.springboot.entity.RequestDetails;
import com.klef.springboot.repository.RecipientRepository;
import com.klef.springboot.repository.RequestDetailsRepository;

@Service
public class RecipientServiceImpl implements RecipientService
{
    @Autowired
    private RecipientRepository recipientRepository;

    @Autowired
    private RequestDetailsRepository requestDetailsRepository;

    // ✅ Register Recipient
    @Override
    public String recipientRegistration(Recipient recipient) 
    {
        recipient.setRole("RECIPIENT");
        recipientRepository.save(recipient);
        return "Recipient Registered Successfully";
    }

    // ✅ Login
    @Override
    public Recipient verifyRecipientLogin(String email, String pwd) 
    {
        return recipientRepository.findByEmail(email);
    }

    // ✅ Update Profile
    @Override
    public String updateRecipientProfile(Recipient recipient) 
    {
        recipientRepository.save(recipient);
        return "Profile Updated Successfully";
    }

    // ✅ Request Item
    @Override
    public String requestItem(RequestDetails request) 
    {
        request.setRequestStatus("Pending");
        requestDetailsRepository.save(request);
        return "Request Submitted Successfully";
    }

    // ✅ View My Requests (FIXED HERE 🔥)
    @Override
    public List<RequestDetails> viewMyRequests(int recipientId) 
    {
        return requestDetailsRepository.findByRecipient_RecipientId(recipientId);
    }

    // ✅ Check Request Status
    @Override
    public String checkRequestStatus(int requestId) 
    {
        RequestDetails request = requestDetailsRepository.findById(requestId).orElse(null);

        if(request != null)
        {
            return request.getRequestStatus();
        }
        return "No Request Found";
    }

    // ✅ Expected Delivery Date
    @Override
    public String getExpectedDeliveryDate(int requestId) 
    {
        RequestDetails request = requestDetailsRepository.findById(requestId).orElse(null);

        if(request != null)
        {
            LocalDate expectedDate = LocalDate.now().plusDays(3);
            return expectedDate.toString();
        }
        return "No Delivery Date Available";
    }

    // ✅ Feedback
    @Override
    public String giveFeedback(int requestId, int rating, String feedback) 
    {
        RequestDetails request = requestDetailsRepository.findById(requestId).orElse(null);

        if(request != null)
        {
            return "Feedback Submitted Successfully";
        }
        return "Request Not Found";
    }
}