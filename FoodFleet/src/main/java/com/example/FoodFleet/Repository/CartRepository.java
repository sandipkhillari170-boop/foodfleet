package com.example.FoodFleet.Repository;

import com.example.FoodFleet.Entity.Cart;
import com.example.FoodFleet.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByCustomerId(Long customerId);
}
