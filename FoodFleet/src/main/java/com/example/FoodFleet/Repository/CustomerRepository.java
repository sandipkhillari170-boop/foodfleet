package com.example.FoodFleet.Repository;

import com.example.FoodFleet.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
