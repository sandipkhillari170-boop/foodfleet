package com.example.FoodFleet.Controller;

import com.example.FoodFleet.DTO.CreateCustomerRequestDto;
import com.example.FoodFleet.DTO.CreateCustomerResponseDto;
import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private CustomerService customerService;

    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CreateCustomerResponseDto> create(@RequestBody CreateCustomerRequestDto customer){
        return ResponseEntity.ok(customerService.create(customer));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateCustomerResponseDto> get(@PathVariable Long id){
        return  ResponseEntity.ok(customerService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<CreateCustomerResponseDto>> getAll(){
        return ResponseEntity.ok(customerService.getall());
    }
}
