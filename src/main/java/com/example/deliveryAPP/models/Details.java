package com.example.deliveryAPP.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "details_table")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
    private Integer detailsId;
    @Column(name = "amount_item", nullable = false)
    private Integer amountItem;
    @Column(name = "sub_total_item", nullable = false)
    private Double subTotalItem;

    @OneToMany(mappedBy = "details")
    @JsonManagedReference
    private List<Order> orders;

    @OneToMany(mappedBy = "details")
    @JsonManagedReference
    private List<Item>items;

    public Details() {
    }

    public Details(Integer detailsId, Integer amountItem, Double subTotalItem) {
        this.detailsId = detailsId;
        this.amountItem = amountItem;
        this.subTotalItem = subTotalItem;
    }

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public Integer getAmountItem() {
        return amountItem;
    }

    public void setAmountItem(Integer amountItem) {
        this.amountItem = amountItem;
    }

    public Double getSubTotalItem() {
        return subTotalItem;
    }

    public void setSubTotalItem(Double subTotalItem) {
        this.subTotalItem = subTotalItem;
    }
}