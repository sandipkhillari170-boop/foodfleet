package com.example.FoodFleet.OrderDto;

public class CreateOrderRequestDto {
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
