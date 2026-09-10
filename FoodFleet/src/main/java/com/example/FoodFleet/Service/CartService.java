package com.example.FoodFleet.Service;

import com.example.FoodFleet.CartDto.CreateRequestDto;
import com.example.FoodFleet.CartDto.ResponseCartDto;
import com.example.FoodFleet.Entity.Cart;
import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.CartMapper;
import com.example.FoodFleet.Repository.CartRepository;
import com.example.FoodFleet.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    private CartMapper cartMapper;

    CartService(CartRepository cartRepository, CustomerRepository customerRepository, CartMapper cartMapper){
        this.cartRepository =cartRepository;
        this.customerRepository = customerRepository;
        this.cartMapper = cartMapper;
    }

    public ResponseCartDto create(CreateRequestDto requestDto){
        Customer customer = customerRepository
                .findByIdAndDeletedFalse(requestDto.getCustomerId())         // dout
                .orElseThrow(()->
                        new ResourceNotFoundException(" customer not available"));
        Cart cart = cartMapper.mapToEntity(requestDto,customer);
        cart.setCustomer(customer);
        cart.setCreatedAt(LocalDateTime.now());
        cart.setUpdatedAt(LocalDateTime.now());

        Cart saveCart = cartRepository.save(cart);
        return cartMapper.mapToDto(saveCart);
    }
}
