package com.example.FoodFleet.Mapper;

import com.example.FoodFleet.DTO.CreateCustomerRequestDto;
import com.example.FoodFleet.DTO.CreateCustomerResponseDto;
import com.example.FoodFleet.Entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer mapToEntity(CreateCustomerRequestDto customerRequestDto){
         Customer customer = new Customer();

         customer.setName(customerRequestDto.getName());
         customer.setEmail(customerRequestDto.getEmail());
         customer.setPhoneNo(customerRequestDto.getPhoneNo());

        return customer;

    }

    public CreateCustomerResponseDto mapToDTO(Customer customer){
        CreateCustomerResponseDto customerResponseDto = new CreateCustomerResponseDto();

        customerResponseDto.setName(customer.getName());
        customerResponseDto.setId(customer.getId());
        customerResponseDto.setPhoneNo(customer.getPhoneNo());
        customerResponseDto.setActive(customer.getActive());
        customerResponseDto.setCreatedAt(customer.getCreatedAt());

        return customerResponseDto;
    }

}
