package com.example.deliveryAPP.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="address_table")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Integer addressId;
    @Column(name = "payment_date",nullable = false)
    private LocalDate paymentDate;
    @Column(name="address_street",length = 255,nullable = false)
    private String addresStreet;
    @Column(name="address_city",length = 100,nullable = false)
    private String addressCity;
    @Column(name="address_postal_code",length = 20,nullable = false)
    private String addressPostalCode;
    @Column(name="address_country",length = 50,nullable = false)
    private String addressCountry;

    public Address() {
    }

    public Address(LocalDate paymentDate, Integer addressId, String addresStreet, String addressCity, String addressPostalCode, String addressCountry) {
        this.paymentDate = paymentDate;
        this.addressId = addressId;
        this.addresStreet = addresStreet;
        this.addressCity = addressCity;
        this.addressPostalCode = addressPostalCode;
        this.addressCountry = addressCountry;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddresStreet() {
        return addresStreet;
    }

    public void setAddresStreet(String addresStreet) {
        this.addresStreet = addresStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPostalCode() {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String addressPostalCode) {
        this.addressPostalCode = addressPostalCode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }
}