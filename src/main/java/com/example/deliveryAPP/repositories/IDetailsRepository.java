package com.example.deliveryAPP.repositories;

import com.example.deliveryAPP.models.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailsRepository extends JpaRepository<Details, Integer> {



}
