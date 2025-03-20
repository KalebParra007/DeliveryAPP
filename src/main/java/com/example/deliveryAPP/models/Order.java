package com.example.deliveryAPP.models;

import com.example.deliveryAPP.helpers.enums.OrderStatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "status_order",nullable = false)
    private OrderStatusEnum statusOrder;
    @Column(name = "order_date",nullable = false)
    private LocalDate orderDate;
    @Column(name = "total_order",nullable = false)
    private Double totalOrder;

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_order", referencedColumnName = "order_id")
    @JsonBackReference
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "fk_shop", referencedColumnName = "store_id")
    @JsonBackReference
    private Store store;

    @ManyToOne
    @JoinColumn(name = "fk_details", referencedColumnName = "details_id")
    @JsonBackReference
    private Details details;

    public Order() {
    }

    public Order(Integer orderId, OrderStatusEnum statusOrder, LocalDate orderDate, Double totalOrder) {
        this.orderId = orderId;
        this.statusOrder = statusOrder;
        this.orderDate = orderDate;
        this.totalOrder = totalOrder;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderStatusEnum getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(OrderStatusEnum statusOrder) {
        this.statusOrder = statusOrder;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Double totalOrder) {
        this.totalOrder = totalOrder;
    }
}