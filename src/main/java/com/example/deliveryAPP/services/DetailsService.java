package com.example.deliveryAPP.services;

import com.example.deliveryAPP.repositories.IDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsService {

    @Autowired
    IDetailsRepository repository;

}
