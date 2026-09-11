package com.example.FoodFleet.Repository;

import com.example.FoodFleet.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
