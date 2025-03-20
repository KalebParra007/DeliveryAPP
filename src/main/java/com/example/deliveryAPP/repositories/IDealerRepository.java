package com.example.deliveryAPP.repositories;

import com.example.deliveryAPP.models.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDealerRepository extends JpaRepository<Dealer, Integer> {



}
