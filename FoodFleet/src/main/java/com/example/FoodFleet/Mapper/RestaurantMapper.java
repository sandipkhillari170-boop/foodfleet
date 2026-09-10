package com.example.FoodFleet.Mapper;

import com.example.FoodFleet.DTORestaurent.CreateRestaurantRequestDto;
import com.example.FoodFleet.DTORestaurent.CreateRestaurantResponseDto;
import com.example.FoodFleet.DTORestaurent.UpdateRestaurantResquestDto;
import com.example.FoodFleet.Entity.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public Restaurant mapToEntity(CreateRestaurantRequestDto requestDto){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(requestDto.getName());
        restaurant.setAddress(requestDto.getAddress());
        restaurant.setPhoneNo(requestDto.getPhoneNo());
        restaurant.setClosingTime(requestDto.getClosingTime());
        restaurant.setOpeningTime(requestDto.getOpeningTime());

        return restaurant;
    }

    public CreateRestaurantResponseDto mapToDto(Restaurant restaurant){
        CreateRestaurantResponseDto responseDto=  new CreateRestaurantResponseDto();
        responseDto.setName(restaurant.getName());
        responseDto.setPhoneNo(restaurant.getPhoneNo());
        responseDto.setId(restaurant.getId());
        responseDto.setAddress(restaurant.getAddress());
        responseDto.setClosingTime(restaurant.getClosingTime());
        responseDto.setOpeningTime(restaurant.getOpeningTime());
        responseDto.setActive(restaurant.getActive());
        responseDto.setCreatedAt(restaurant.getCreatedAt());

        return responseDto;
    }
    public Restaurant updateMapToEntity(UpdateRestaurantResquestDto resquestDto,
                                        Restaurant restaurant){
        restaurant.setName(resquestDto.getName());
        restaurant.setPhoneNo(resquestDto.getPhoneNo());
        restaurant.setOpeningTime(resquestDto.getOpeningTime());
        restaurant.setClosingTime(resquestDto.getClosingTime());

        return restaurant;
    }
}
