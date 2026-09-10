package com.example.FoodFleet.Service;

import com.example.FoodFleet.CartItemDto.CreateCartItemRequestDto;
import com.example.FoodFleet.CartItemDto.UpadateCartItemRequestDto;
import com.example.FoodFleet.Entity.Cart;
import com.example.FoodFleet.Entity.CartItem;
import com.example.FoodFleet.Entity.Menu;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.CartItemMapper;
import com.example.FoodFleet.Mapper.CartMapper;
import com.example.FoodFleet.Repository.CartItemRepository;
import com.example.FoodFleet.Repository.CartRepository;
import com.example.FoodFleet.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private CartItemRepository cartItemRepository;
    private MenuRepository menuRepository;
    private CartRepository cartRepository;
    private CartItemMapper cartItemMapper;

    public CartItemService(CartItemRepository cartItemRepository,
                           CartRepository cartRepository,
                           MenuRepository menuRepository,
                           CartItemMapper cartItemMapper) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.menuRepository = menuRepository;
        this.cartItemMapper = cartItemMapper;
    }

    public CartItem addItem(CreateCartItemRequestDto requestDto){
        Cart cart= cartRepository.findById(requestDto.getCartId())
                .orElseThrow(()-> new ResourceNotFoundException(" Customer not found "));

        Menu menu = menuRepository.findById(requestDto.getMenuId())
                .orElseThrow(()-> new ResourceNotFoundException(" Menu not Available "));

        CartItem cartItem = cartItemMapper.mapToEntity(requestDto,menu,cart);

        return cartItemRepository.save(cartItem);
    }
    public List<CartItem> get(Long cartId) {

        cartRepository.findById(cartId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart not found"));

        return cartItemRepository.findByCartId(cartId);
    }

    public CartItem update(Long id, UpadateCartItemRequestDto requestDto){
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(" cart Item not found"));
        cartItem.setQuantity(requestDto.getQuantity());
        return cartItemRepository.save(cartItem);
    }

    public String deleteCartItem(Long Id) {

        CartItem cartItem = cartItemRepository.findById(Id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("CartItem not found"));
        cartItemRepository.delete(cartItem);
        return "CartItem Deleted";
    }

//    public String softDelete(Long id){
//        CartItem cartItem = cartItemRepository.findById(id)
//                .orElseThrow(()-> new ResourceNotFoundException(" cartItem not found"));
//
//        ;
//    }



}
