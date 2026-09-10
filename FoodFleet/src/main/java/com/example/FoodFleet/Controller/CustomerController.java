package com.example.FoodFleet.Controller;

import com.example.FoodFleet.DTOCustomer.CreateCustomerRequestDto;
import com.example.FoodFleet.DTOCustomer.CreateCustomerResponseDto;
import com.example.FoodFleet.DTOCustomer.UpdateCustomerRequestDTO;
import com.example.FoodFleet.DTOCustomer.UpdateCustomerResponseDTO;
import com.example.FoodFleet.Service.CustomerService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CreateCustomerResponseDto> create(
            @Valid @RequestBody CreateCustomerRequestDto customer){
        return ResponseEntity.ok(customerService.create(customer));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateCustomerResponseDto> get(@PathVariable Long id){
        return  ResponseEntity.ok(customerService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<CreateCustomerResponseDto>> getall(){
        return ResponseEntity.ok(customerService.getall());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCustomerResponseDTO> update(@PathVariable Long id,
                                                            @RequestBody UpdateCustomerRequestDTO updateRequestDTO){
        return ResponseEntity.ok(customerService.update(id, updateRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(customerService.delete(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Long id){
//        return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(customerService.softDelete(id));
    }

}
