package com.example.FoodFleet.Exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String Message){
        super(Message);
    }
}
