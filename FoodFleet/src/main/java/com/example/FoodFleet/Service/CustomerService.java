package com.example.FoodFleet.Service;

import com.example.FoodFleet.DTO.CreateCustomerRequestDto;
import com.example.FoodFleet.DTO.CreateCustomerResponseDto;
import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Mapper.CustomerMapper;
import com.example.FoodFleet.Repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;


    CustomerService(CustomerRepository customerRepository,
                    CustomerMapper customerMapper){
        this.customerRepository=customerRepository;
        this.customerMapper = customerMapper;
    }

    public CreateCustomerResponseDto create(CreateCustomerRequestDto customerRequest){

        Customer customer = customerMapper.mapToEntity(customerRequest);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());
        Customer saveCustomer = customerRepository.save(customer);

        return customerMapper.mapToDTO(saveCustomer);
    }
}
