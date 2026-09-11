package com.example.FoodFleet.Mapper;

import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Entity.Order;
import com.example.FoodFleet.OrderDto.CreateOrderRequestDto;
import com.example.FoodFleet.OrderDto.ResponseOrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order mapToEntity(CreateOrderRequestDto requestDto,
                                     Customer customer){
        Order order = new Order();
        order.setCustomer(customer);

        return order;
    }
    public ResponseOrderDto mapToDto(Order order){
        ResponseOrderDto responseOrderDto = new ResponseOrderDto();

        responseOrderDto.setId(order.getId());
        responseOrderDto.setCustomerId(order.getCustomer().getId());
        responseOrderDto.setTotalAmount(order.getTotalAmount());
        responseOrderDto.setStatus(order.getStatus());
        responseOrderDto.setCreatedAt(order.getCreatedAt());
        responseOrderDto.setUpdatedAt(order.getUpdatedAt());
        return responseOrderDto;
    }
}
