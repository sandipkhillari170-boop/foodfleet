package com.example.FoodFleet.Controller;

import com.example.FoodFleet.OrderDto.CreateOrderRequestDto;
import com.example.FoodFleet.OrderDto.ResponseOrderDto;
import com.example.FoodFleet.Service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ResponseOrderDto> create(@RequestBody CreateOrderRequestDto requestDto){
        return ResponseEntity.ok(orderService.Create(requestDto));
    }
}
