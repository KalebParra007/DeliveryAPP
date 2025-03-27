package com.example.deliveryAPP.services;

import com.example.deliveryAPP.repositories.IDealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealerService {

    @Autowired
    IDealerRepository repository;

}
