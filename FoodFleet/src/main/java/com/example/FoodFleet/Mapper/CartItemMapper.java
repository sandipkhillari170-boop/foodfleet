package com.example.FoodFleet.Mapper;

import com.example.FoodFleet.CartItemDto.CreateCartItemRequestDto;
import com.example.FoodFleet.Entity.Cart;
import com.example.FoodFleet.Entity.CartItem;
import com.example.FoodFleet.Entity.Menu;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {
    public CartItem mapToEntity(CreateCartItemRequestDto requestDto,
                                Menu menu, Cart cart){
        CartItem cartItem = new CartItem();
        cartItem.setMenu(menu);
        cartItem.setCart(cart);
        cartItem.setQuantity(requestDto.getQuantity());
        return cartItem;
    }
}
