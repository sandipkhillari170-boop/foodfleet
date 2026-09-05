package com.example.FoodFleet.Repository;

import com.example.FoodFleet.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    Optional<Restaurant> findByIdAndDeletedFalse(Long id);
    List<Restaurant> findAllByDeletedFalse();

}
