package com.example.FoodFleet.Service;

import com.example.FoodFleet.Entity.*;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.OrderMapper;
import com.example.FoodFleet.OrderDto.CreateOrderRequestDto;
import com.example.FoodFleet.OrderDto.ResponseOrderDto;
import com.example.FoodFleet.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private OrderItemRepository orderItemRepository;

    OrderService(CustomerRepository customerRepository,
                 OrderRepository orderRepository,
                 OrderMapper orderMapper,
                 CartRepository cartRepository,
                 CartItemRepository cartItemRepository,
                 OrderItemRepository orderItemRepository){
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderItemRepository = orderItemRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository=cartRepository;
    }
    @Transactional
    public ResponseOrderDto create(CreateOrderRequestDto requestDto) {
        // find Customer
        Customer customer = customerRepository
                .findByIdAndDeletedFalse(requestDto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(" customer not available "));

        // find customer cart
        Cart cart = cartRepository.findByCustomerId(customer.getId())
                .orElseThrow(() -> new ResourceNotFoundException(" Customer is not found in cart"));

        // find the items of in cart
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
        if (cartItems.isEmpty()) {
            throw new ResourceNotFoundException(" cart item is Empty !");
        }

        // Total Amount calculation
        Double totalAmount = 0.0;
        for (CartItem cartItem : cartItems) {

            Double price = cartItem.getMenu().getPrice();
            Integer quantity = cartItem.getQuantity();

            totalAmount = totalAmount + (price * quantity);
        }
        // Order object Create
        Order order = orderMapper.mapToEntity(requestDto, customer);
        order.setStatus("CREATED");
        order.setTotalAmount(totalAmount);    // Order ka Total set
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderRepository.save(order);

        // set price and Quantity.
        for (CartItem cartItem : cartItems) {
            // create OrderItem Object
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(saveOrder);
            orderItem.setMenu(cartItem.getMenu());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getMenu().getPrice());

            orderItemRepository.save(orderItem);
        }

        // Response Dto return
        return orderMapper.mapToDto(saveOrder);
    }
}
