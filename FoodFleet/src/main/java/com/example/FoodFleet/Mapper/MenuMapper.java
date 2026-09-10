package com.example.FoodFleet.Mapper;

import com.example.FoodFleet.DTOMenu.CreateMenuRequestDto;
import com.example.FoodFleet.DTOMenu.ResponseMenuDto;
import com.example.FoodFleet.DTOMenu.UpdateMenuRequestDto;
import com.example.FoodFleet.Entity.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {
    public Menu mapToEntity(CreateMenuRequestDto requestDto){
        Menu menu = new Menu();
        menu.setName(requestDto.getName());
        menu.setPrice(requestDto.getPrice());
        menu.setDescription(requestDto.getDescription());
        menu.setCategory(requestDto.getCategory());

        return menu;
    }

    public ResponseMenuDto mapToDto(Menu menu){
        ResponseMenuDto responseMenuDto = new ResponseMenuDto();
        responseMenuDto.setName(menu.getName());
        responseMenuDto.setPrice(menu.getPrice());
        responseMenuDto.setCategory(menu.getCategory());
        responseMenuDto.setDescription(menu.getDescription());
        responseMenuDto.setId(menu.getId());
        responseMenuDto.setAvailable(menu.getAvailable());
        responseMenuDto.setCreatedAt(menu.getCreatedAt());
        responseMenuDto.setUpdatedAt(menu.getUpdatedAt());
        responseMenuDto.setRestaurantId(menu.getRestaurant().getId());
        return responseMenuDto;
    }

    public Menu UpdateMapToEntity(UpdateMenuRequestDto requestDto,
                                          Menu menu){
        menu.setName(requestDto.getName());
        menu.setPrice(requestDto.getPrice());
        menu.setCategory(requestDto.getCategory());
        menu.setDescription(requestDto.getDescription());

        return menu;
    }
}
