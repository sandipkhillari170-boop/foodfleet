package com.example.FoodFleet.Service;

import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Entity.Order;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.OrderMapper;
import com.example.FoodFleet.OrderDto.CreateOrderRequestDto;
import com.example.FoodFleet.OrderDto.ResponseOrderDto;
import com.example.FoodFleet.Repository.CustomerRepository;
import com.example.FoodFleet.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    OrderService(CustomerRepository customerRepository,
                 OrderRepository orderRepository,
                 OrderMapper orderMapper){
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }
    public ResponseOrderDto Create(CreateOrderRequestDto requestDto){
        Customer customer = customerRepository
                .findByIdAndDeletedFalse(requestDto.getCustomerId())
                .orElseThrow(()-> new ResourceNotFoundException(" customer not available "));

        Order order = orderMapper.mapToEntity(requestDto,customer);
        order.setTotalAmount(0.0);
        order.setStatus("CREATED");
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        orderRepository.save(order);
        return orderMapper.mapToDto(order);

    }
}
