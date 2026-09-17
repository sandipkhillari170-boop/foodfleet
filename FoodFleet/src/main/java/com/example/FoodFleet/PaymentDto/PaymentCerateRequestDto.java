package com.example.FoodFleet.PaymentDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PaymentCerateRequestDto {
    @NotNull(message = "id is required !")
    private Long orderId;
    @NotBlank(message = " payment method is required")
    private String paymentMethod;

    public Long getOrderId(){
        return orderId;
    }
    public void setOrderId(Long orderId){
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
