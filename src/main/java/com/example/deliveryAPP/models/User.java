package com.example.deliveryAPP.models;

import com.example.deliveryAPP.helpers.enums.UserEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(name = "user_name",length = 100,nullable = false)
    private String name;
    @Column(name = "user_email",length = 150, unique = true, nullable = false)
    private String email;
    @Column(name = "user_password",length = 250,nullable = false)
    private  String password;
    @Column(name = "user_phone",length = 20,nullable = false)
    private String numberPhone;
    @Column(name = "user_type",nullable = false)
    private UserEnum userType;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Order> orders;

    //Methods

    //Void Constructor
    public User() {
    }

    //Constructor User
    public User(Integer id, String name, String email, String password, String numberPhone, UserEnum userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.numberPhone = numberPhone;
        this.userType = userType;
    }

    //Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public UserEnum getUserType() {
        return userType;
    }

    public void setUserType(UserEnum userType) {
        this.userType = userType;
    }
}