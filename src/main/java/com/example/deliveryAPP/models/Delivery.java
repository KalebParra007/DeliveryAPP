package com.example.deliveryAPP.models;

import com.example.deliveryAPP.helpers.enums.DeliveryEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="delivery_table")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Integer deliveryId;
    @Column(name = "status_delivery",nullable = false)
    private DeliveryEnum StatusDelivery;
    @Column(name = "delivery_date",nullable = false)
    private LocalDate deliveryDate;

    public Delivery() {
    }

    public Delivery(Integer deliveryId, DeliveryEnum statusDelivery, LocalDate deliveryDate) {
        this.deliveryId = deliveryId;
        StatusDelivery = statusDelivery;
        this.deliveryDate = deliveryDate;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public DeliveryEnum getStatusDelivery() {
        return StatusDelivery;
    }

    public void setStatusDelivery(DeliveryEnum statusDelivery) {
        StatusDelivery = statusDelivery;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
