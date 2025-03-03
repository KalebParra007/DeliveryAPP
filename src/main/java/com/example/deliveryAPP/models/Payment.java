package com.example.deliveryAPP.models;

import com.example.deliveryAPP.helpers.enums.PaymentStatusEnum;
import com.example.deliveryAPP.helpers.enums.PaymentMethodEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "payment_table")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Column(name = "payment_method",nullable = false)
    private PaymentMethodEnum paymentMethod;
    @Column(name = "payment_status",nullable = false)
    private PaymentStatusEnum paymenStatus;
    @Column(name = "payment_date",nullable = false)
    private LocalDate paymenDate;

    public Payment() {
    }

    public Payment(Integer paymentId, PaymentMethodEnum paymentMethod, PaymentStatusEnum paymenStatus, LocalDate paymenDate) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.paymenStatus = paymenStatus;
        this.paymenDate = paymenDate;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatusEnum getPaymenStatus() {
        return paymenStatus;
    }

    public void setPaymenStatus(PaymentStatusEnum paymenStatus) {
        this.paymenStatus = paymenStatus;
    }

    public LocalDate getPaymenDate() {
        return paymenDate;
    }

    public void setPaymenDate(LocalDate paymenDate) {
        this.paymenDate = paymenDate;
    }
}