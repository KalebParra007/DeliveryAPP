package com.example.deliveryAPP.repositories;

import com.example.deliveryAPP.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {



}
