package com.example.FoodFleet.Service;

import com.example.FoodFleet.DTOMenu.CreateMenuRequestDto;
import com.example.FoodFleet.DTOMenu.ResponseMenuDto;
import com.example.FoodFleet.DTOMenu.UpdateMenuRequestDto;
import com.example.FoodFleet.Entity.Menu;
import com.example.FoodFleet.Entity.Restaurant;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.MenuMapper;
import com.example.FoodFleet.Repository.MenuRepository;
import com.example.FoodFleet.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    private MenuRepository menuRepository;
    private MenuMapper menuMapper;
    private RestaurantRepository restaurantRepository;

    public MenuService(MenuRepository menuRepository,MenuMapper menuMapper, RestaurantRepository restaurantRepository){
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
        this.restaurantRepository = restaurantRepository;
    }
    public ResponseMenuDto cteate(CreateMenuRequestDto requestDto){
        Restaurant restaurant = restaurantRepository.findByIdAndDeletedFalse(requestDto.getRestaurantId())
                .orElseThrow(()-> new ResourceNotFoundException("Restaurant is NOT Available"));

        Menu menu = menuMapper.mapToEntity(requestDto);
        menu.setRestaurant(restaurant);
        menu.setCreatedAt(LocalDateTime.now());
        menu.setUpdatedAt(LocalDateTime.now());
        Menu saveMenu = menuRepository.save(menu);
        return menuMapper.mapToDto(saveMenu);
    }

    public ResponseMenuDto get(Long id) {
        Menu menu = menuRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("menu  not found !"));
        return menuMapper.mapToDto(menu);
    }

    public List<ResponseMenuDto> getAll(){
        List<Menu> menu = menuRepository.findAllByAndDeletedFalse();
        List<ResponseMenuDto>  responseMenuDto = new ArrayList<>();
        for(Menu menus : menu){
           ResponseMenuDto Dto = menuMapper.mapToDto(menus);
           responseMenuDto.add(Dto);
        }
        return responseMenuDto;
    }

    public ResponseMenuDto update(Long id, UpdateMenuRequestDto requestDto){
        Menu menu = menuRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException(" not found !"));
        menuMapper.UpdateMapToEntity(requestDto,menu);
        menu.setUpdatedAt(LocalDateTime.now());
        Menu saveMenu = menuRepository.save(menu);
        return menuMapper.mapToDto(saveMenu);
    }

    public String delete(Long id){
        Menu menu = menuRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(" not Found !"));
        menuRepository.delete(menu);
        return  "Deletion success !";

    }

    public String softDelete(Long id){
        Menu menu = menuRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException(" Not Found !"));
        menu.setDeleted(true);
        menuRepository.save(menu);
        return "soft deletion success !";
    }


}
