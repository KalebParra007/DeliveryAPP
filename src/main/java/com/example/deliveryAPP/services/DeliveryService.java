package com.example.deliveryAPP.services;

import com.example.deliveryAPP.repositories.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    IDeliveryRepository repository;

}
