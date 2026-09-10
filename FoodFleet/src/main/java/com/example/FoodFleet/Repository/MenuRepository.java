package com.example.FoodFleet.Repository;

import com.example.FoodFleet.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> findByIdAndDeletedFalse(Long id);
    List<Menu> findAllByAndDeletedFalse();
}
