package com.example.FoodFleet.Service;

import com.example.FoodFleet.DTO.CreateRestaurantRequestDto;
import com.example.FoodFleet.DTO.CreateRestaurantResponseDto;
import com.example.FoodFleet.DTO.UpdateRestaurantResquestDto;
import com.example.FoodFleet.Entity.Restaurant;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.RestaurantMapper;
import com.example.FoodFleet.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    private RestaurantMapper restaurantMapper;

    RestaurantService(RestaurantRepository restaurantRepository,
                      RestaurantMapper restaurantMapper){
        this.restaurantRepository=restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public CreateRestaurantResponseDto create(CreateRestaurantRequestDto requestDto){
        Restaurant restaurant = restaurantMapper.mapToEntity(requestDto);

        restaurant.setCreatedAt(LocalDateTime.now());
        restaurant.setUpdatedAt(LocalDateTime.now());
        Restaurant saveRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.mapToDto(saveRestaurant);
    }

    public CreateRestaurantResponseDto get(Long id){
        Restaurant restaurant = restaurantRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Restaurent is not found"));
        return restaurantMapper.mapToDto(restaurant);
    }

    public List<CreateRestaurantResponseDto> getAll(){
        List<Restaurant> restaurants =  restaurantRepository.findAllByDeletedFalse();
        List<CreateRestaurantResponseDto> responseDtos = new ArrayList<>();
        for(Restaurant restaurant : restaurants){
            CreateRestaurantResponseDto Dto = restaurantMapper.mapToDto(restaurant);
            responseDtos.add(Dto);
        }
        return responseDtos;
    }
    public CreateRestaurantResponseDto update(Long id , UpdateRestaurantResquestDto resquestDto){
        Restaurant restaurant = restaurantRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Restaurent is not found"));
        restaurantMapper.updateMapToEntity(resquestDto,restaurant);
        restaurant.setUpdatedAt(LocalDateTime.now());
        Restaurant saveRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.mapToDto(saveRestaurant);

    }

    public String softDelete(Long id){
        Restaurant restaurant = restaurantRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Restaurent is not found"));
        restaurant.setDeleted(true);
        restaurantRepository.save(restaurant);
        return "delete successfully";
    }
    public String delete(Long id){
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(" no restaurant found"));
        restaurantRepository.delete(restaurant);
        return "delete successfully !";
    }
}
