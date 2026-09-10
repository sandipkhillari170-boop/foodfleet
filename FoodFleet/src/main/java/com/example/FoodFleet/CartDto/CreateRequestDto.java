package com.example.FoodFleet.CartDto;

public class CreateRequestDto {
    private Long customerId;

    public Long getCustomerId(){
        return customerId;
    }
    public void setCustomerId(Long customerId){
        this.customerId= customerId;
    }

}
