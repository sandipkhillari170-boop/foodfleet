package com.example.FoodFleet.Mapper;

import com.example.FoodFleet.Entity.Order;
import com.example.FoodFleet.Entity.Payment;
import com.example.FoodFleet.PaymentDto.PaymentCerateRequestDto;
import com.example.FoodFleet.PaymentDto.PaymentResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment mapToEntity(PaymentCerateRequestDto dto,
                               Order order){
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setPaymentMethod(dto.getPaymentMethode());
        payment.setAmount(order.getTotalAmount());

        return payment;
    }
    public PaymentResponseDto mapToDto(Payment payment){
        PaymentResponseDto responseDto = new PaymentResponseDto();
        responseDto.setAmount(payment.getAmount());
        responseDto.setOrderId(payment.getOrder().getId());
        responseDto.setStatus(payment.getStatus());
        responseDto.setId(payment.getId());
        responseDto.setPaymentMethod(payment.getPaymentMethod());

        return responseDto;
    }

}
