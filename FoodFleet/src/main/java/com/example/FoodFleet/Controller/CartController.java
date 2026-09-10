package com.example.FoodFleet.Controller;


import com.example.FoodFleet.CartDto.CreateRequestDto;
import com.example.FoodFleet.CartDto.ResponseCartDto;
import com.example.FoodFleet.Service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<ResponseCartDto> createCart(
            @RequestBody CreateRequestDto requestDto) {

        return ResponseEntity.ok(
                cartService.create(requestDto));
    }
}