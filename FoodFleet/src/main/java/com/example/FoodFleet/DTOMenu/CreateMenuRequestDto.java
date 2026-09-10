package com.example.FoodFleet.DTOMenu;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateMenuRequestDto {
    @NotBlank(message = "name is require ")
    @Column(unique = true)
    private String name;
    private String description;
    @NotNull(message = "Price is require ")
    private Double price;
    @NotBlank(message = "category is require")
    private String category;
    private Boolean available = true;
    private Long restaurantId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getRestaurantId(){
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId){
        this.restaurantId = restaurantId;
    }
}
