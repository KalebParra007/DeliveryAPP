package com.example.deliveryAPP.repositories;

import com.example.deliveryAPP.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    //Aca dentro del repo van las consultas personalizadas



}
