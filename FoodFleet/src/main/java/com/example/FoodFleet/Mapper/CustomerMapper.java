package com.example.FoodFleet.Mapper;

import com.example.FoodFleet.DTO.CreateCustomerRequestDto;
import com.example.FoodFleet.DTO.CreateCustomerResponseDto;
import com.example.FoodFleet.DTO.UpdateRequestDTO;
import com.example.FoodFleet.DTO.UpdateResponseDTO;
import com.example.FoodFleet.Entity.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
        customerResponseDto.setEmail(customer.getEmail());

        return customerResponseDto;
    }
    
    public Customer updateMapToEntity(UpdateRequestDTO updateRequestDTO, Customer customer){
        customer.setName(updateRequestDTO.getName());
        customer.setPhoneNo(updateRequestDTO.getPhoneNo());
        customer.setActive(updateRequestDTO.getActive());
        
        return customer;
    }
    
    public UpdateResponseDTO updateMapToDTO(Customer customer){
        UpdateResponseDTO updateResponseDTO = new UpdateResponseDTO();

        updateResponseDTO.setName(customer.getName());
        updateResponseDTO.setId(customer.getId());
        updateResponseDTO.setPhoneNo(customer.getPhoneNo());
        updateResponseDTO.setActive(customer.getActive());
        updateResponseDTO.setCreatedAt(customer.getCreatedAt());
        updateResponseDTO.setEmail(customer.getEmail());
        
        return updateResponseDTO;
    }

}
