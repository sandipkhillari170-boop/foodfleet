package com.example.FoodFleet.Controller;

import com.example.FoodFleet.Entity.OrderItem;
import com.example.FoodFleet.Service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-item")
public class OrderItemCntroller {
    private OrderItemService orderItemService;
    OrderItemCntroller(OrderItemService orderItemService){
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItem>> findItemByOrderId(@PathVariable Long orderId){
        return ResponseEntity.ok(orderItemService.getItemByOrderId(orderId));
    }
}
