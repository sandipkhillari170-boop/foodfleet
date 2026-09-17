package com.example.FoodFleet.Repository;

import com.example.FoodFleet.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
