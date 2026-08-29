package com.example.FoodFleet.Controller;

import com.example.FoodFleet.DTO.CreateCustomerRequestDto;
import com.example.FoodFleet.DTO.CreateCustomerResponseDto;
import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private CustomerService customerService;

    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CreateCustomerResponseDto> Create(@RequestBody CreateCustomerRequestDto customer){
        return ResponseEntity.ok(customerService.create(customer));


    }
}
