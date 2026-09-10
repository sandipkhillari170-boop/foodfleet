package com.example.FoodFleet.Controller;

import com.example.FoodFleet.CartItemDto.CreateCartItemRequestDto;
import com.example.FoodFleet.CartItemDto.UpadateCartItemRequestDto;
import com.example.FoodFleet.Entity.CartItem;
import com.example.FoodFleet.Service.CartItemService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-item")
public class CartItemController {
    private CartItemService cartItemService;

    CartItemController(CartItemService cartItemService){
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public ResponseEntity<CartItem> addItem(@Valid  @RequestBody CreateCartItemRequestDto requestDto){
        return ResponseEntity.ok(cartItemService.addItem(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CartItem>> get(@PathVariable Long id){
        return ResponseEntity.ok(cartItemService.get(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CartItem> update(@PathVariable Long id,
                                           @RequestBody UpadateCartItemRequestDto requestDto){
        return ResponseEntity.ok(cartItemService.update(id,requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(cartItemService.deleteCartItem(id));
    }
//    @PatchMapping("/{id}")
//    public ResponseEntity<String> softDelete(@PathVariable Long id){
//        return ResponseEntity.ok(cartItemService.softdelete(id));
//    }
}
