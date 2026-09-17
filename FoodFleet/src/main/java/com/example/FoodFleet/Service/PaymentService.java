package com.example.FoodFleet.Service;

import com.example.FoodFleet.Entity.Order;
import com.example.FoodFleet.Entity.Payment;
import com.example.FoodFleet.Exception.DuplicateException;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.PaymentMapper;
import com.example.FoodFleet.PaymentDto.PaymentCerateRequestDto;
import com.example.FoodFleet.PaymentDto.PaymentResponseDto;
import com.example.FoodFleet.PaymentDto.UpdatePaymentRequstDto;
import com.example.FoodFleet.Repository.OrderRepository;
import com.example.FoodFleet.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        if(paymentRepository.existsByOrderId(requestDto.getOrderId())){
            throw new DuplicateException("Payment already exists for this order");
        }

        Payment payment = paymentMapper.mapToEntity(requestDto,order);
        payment.setStatus("Success..");

        Payment savePayment = paymentRepository.save(payment);
        return paymentMapper.mapToDto(savePayment);

    }
    public PaymentResponseDto get(Long id){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(" Payment record NOT found"));
        return paymentMapper.mapToDto(payment);
    }

    public List<PaymentResponseDto> getAll(){
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentResponseDto> responseDtos = new ArrayList<>();
        for(Payment payment : payments) {
            PaymentResponseDto dto = paymentMapper.mapToDto(payment);
            responseDtos.add(dto);
        }
        return responseDtos;
    }
    public PaymentResponseDto update(Long id, UpdatePaymentRequstDto updatePaymentDto ){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Payment  not exist "));
        payment.setPaymentMethod(updatePaymentDto.getPaymentMethod());
        Payment saveupdate = paymentRepository.save(payment);

        return paymentMapper.mapToDto(saveupdate);
    }

    public String delete(Long id){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Payment not found To delete"));
        paymentRepository.delete(payment);
        return "delete successfully !";

    }
}