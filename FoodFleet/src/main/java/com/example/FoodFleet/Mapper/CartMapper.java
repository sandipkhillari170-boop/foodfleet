package com.example.FoodFleet.Mapper;

import com.example.FoodFleet.CartDto.CreateRequestDto;
import com.example.FoodFleet.CartDto.ResponseCartDto;
import com.example.FoodFleet.Entity.Cart;
import com.example.FoodFleet.Entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public Cart mapToEntity(CreateRequestDto requestDto,
                            Customer customer) {

        Cart cart = new Cart();

        cart.setCustomer(customer);

        return cart;
    }

    public ResponseCartDto mapToDto(Cart cart) {

        ResponseCartDto dto = new ResponseCartDto();

        dto.setId(cart.getId());
        dto.setCustomerId(cart.getCustomer().getId());
        dto.setCreatedAt(cart.getCreatedAt());
        dto.setUpdatedAt(cart.getUpdatedAt());
        dto.setActive(cart.getActive());

        return dto;
    }
}
