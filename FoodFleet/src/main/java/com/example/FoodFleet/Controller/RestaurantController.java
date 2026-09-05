package com.example.FoodFleet.Controller;

import com.example.FoodFleet.DTO.*;
import com.example.FoodFleet.Entity.Restaurant;
import com.example.FoodFleet.Service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    private RestaurantService restaurantService;

    RestaurantController(RestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }

    @PostMapping
    public ResponseEntity<CreateRestaurantResponseDto> create(@Valid  @RequestBody
                                                              CreateRestaurantRequestDto requestDto){
        return ResponseEntity.ok(restaurantService.create(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateRestaurantResponseDto> get(@PathVariable Long id){
        return ResponseEntity.ok(restaurantService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<CreateRestaurantResponseDto>> getAll(){
        return ResponseEntity.ok(restaurantService.getAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreateRestaurantResponseDto> update(@PathVariable Long id,
                                                            @RequestBody UpdateRestaurantResquestDto requestDto){
        return ResponseEntity.ok(restaurantService.update(id,requestDto));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Long id){
        return ResponseEntity.ok(restaurantService.softDelete(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(restaurantService.delete(id));
    }
}