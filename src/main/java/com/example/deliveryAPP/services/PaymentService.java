package com.example.deliveryAPP.services;

import com.example.deliveryAPP.repositories.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    IPaymentRepository repository;

}
