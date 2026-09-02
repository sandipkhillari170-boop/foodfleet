package com.example.FoodFleet.Repository;

import com.example.FoodFleet.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer>findByIdAndDeletedFalse(Long id);
    List<Customer> findAllByDeletedFalse();
}
