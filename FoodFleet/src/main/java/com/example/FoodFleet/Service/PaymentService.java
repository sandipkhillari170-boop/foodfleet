package com.example.FoodFleet.Service;

import com.example.FoodFleet.Entity.Order;
import com.example.FoodFleet.Entity.Payment;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.PaymentMapper;
import com.example.FoodFleet.PaymentDto.PaymentCerateRequestDto;
import com.example.FoodFleet.PaymentDto.PaymentResponseDto;
import com.example.FoodFleet.Repository.OrderRepository;
import com.example.FoodFleet.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;
    private PaymentMapper paymentMapper;

    public PaymentService(OrderRepository orderRepository,
                          PaymentRepository paymentRepository,
                          PaymentMapper paymentMapper){
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.paymentMapper =paymentMapper;
    }

    public PaymentResponseDto create(PaymentCerateRequestDto requestDto){
        Order order = orderRepository.findById(requestDto.getOrderId())
                .orElseThrow(()-> new ResourceNotFoundException("order not found !"));

        Payment payment = paymentMapper.mapToEntity(requestDto,order);
        payment.setStatus("Success..");

        Payment savePayment = paymentRepository.save(payment);
        return paymentMapper.mapToDto(savePayment);


    }
}
