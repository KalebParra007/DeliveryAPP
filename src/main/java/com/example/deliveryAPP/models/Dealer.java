package com.example.deliveryAPP.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="dealer_table")
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dealer_id")
    private Integer dealerId;
    @Column(name = "dealer_name",length = 100,nullable = false)
    private String dealerName;
    @Column(name = "dealer_phone_number",length = 20,nullable = false)
    private String dealerPhoneNumber;
    @Column(name = "dealer_email",length = 150,nullable = false)
    private String dealerEmail;
    @Column(name = "dealer_vehicle",length = 50,nullable = false)
    private String dealerVehicle;

    @OneToMany(mappedBy = "dealer")
    //@JsonManagedReference
    private List<Delivery> deliveries;

    public Dealer() {
    }

    public Dealer(Integer dealerId, String dealerName, String dealerPhoneNumber, String dealerEmail, String dealerVehicle) {
        this.dealerId = dealerId;
        this.dealerName = dealerName;
        this.dealerPhoneNumber = dealerPhoneNumber;
        this.dealerEmail = dealerEmail;
        this.dealerVehicle = dealerVehicle;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerPhoneNumber() {
        return dealerPhoneNumber;
    }

    public void setDealerPhoneNumber(String dealerPhoneNumber) {
        this.dealerPhoneNumber = dealerPhoneNumber;
    }

    public String getDealerEmail() {
        return dealerEmail;
    }

    public void setDealerEmail(String dealerEmail) {
        this.dealerEmail = dealerEmail;
    }

    public String getDealerVehicle() {
        return dealerVehicle;
    }

    public void setDealerVehicle(String dealerVehicle) {
        this.dealerVehicle = dealerVehicle;
    }
}