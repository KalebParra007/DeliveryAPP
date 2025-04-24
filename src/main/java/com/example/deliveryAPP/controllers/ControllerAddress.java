package com.example.deliveryAPP.controllers;

import com.example.deliveryAPP.models.Address;
import com.example.deliveryAPP.models.User;
import com.example.deliveryAPP.services.AddressService;
import com.example.deliveryAPP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class ControllerAddress {

    @Autowired
    AddressService addressService;


}
