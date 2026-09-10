package com.example.FoodFleet.DTORestaurent;

import com.example.FoodFleet.Entity.Restaurant;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class CreateRestaurantRequestDto {
    @NotBlank(message = "name ie require")
    private String name;
    @NotBlank(message = "Address is require")
    @Column(unique = true)
    private String address;
    @NotEmpty(message = "Phone no is require")
    private String phoneNo;
    @NotNull(message = " Mention closing time")
    private LocalTime closingTime ;
    @NotNull(message = "mention opening time")
    private LocalTime openingTime;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

}
