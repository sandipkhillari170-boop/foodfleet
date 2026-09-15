package com.example.FoodFleet.Service;

import com.example.FoodFleet.Entity.OrderItem;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Repository.OrderItemRepository;
import com.example.FoodFleet.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private OrderItemRepository orderItemRepository;
    OrderItemService(OrderItemRepository orderItemRepository){
        this.orderItemRepository =orderItemRepository;
    }

    public List<OrderItem> getItemByOrderId(Long orderId){
        List<OrderItem> orderItem = orderItemRepository.findByOrderId(orderId);
        if(orderItem.isEmpty()){
            throw new ResourceNotFoundException(" no order found");
        }
        return orderItem;
    }
}
