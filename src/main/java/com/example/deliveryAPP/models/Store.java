package com.example.deliveryAPP.models;

import jakarta.persistence.*;

@Entity
@Table(name = "store_table")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "store_name", length = 100, nullable = false)
    private String storeName;
    @Column(name = "store_address", length = 255, nullable = false)
    private String storeAddres;
    @Column(name = "store_phone_number", length = 20, nullable = false)
    private String storePhoneNumber;
    @Column(name = "store_category", length = 50, nullable = false)
    private String storeCategory;

    public Store() {
    }

    public Store(Integer storeId, String storeName, String storeAddres, String storePhoneNumber, String storeCategory) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeAddres = storeAddres;
        this.storePhoneNumber = storePhoneNumber;
        this.storeCategory = storeCategory;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddres() {
        return storeAddres;
    }

    public void setStoreAddres(String storeAddres) {
        this.storeAddres = storeAddres;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public String getStoreCategory() {
        return storeCategory;
    }

    public void setStoreCategory(String storeCategory) {
        this.storeCategory = storeCategory;
    }
}