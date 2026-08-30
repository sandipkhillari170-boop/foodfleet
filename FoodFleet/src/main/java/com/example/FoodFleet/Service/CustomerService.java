package com.example.FoodFleet.Service;

import com.example.FoodFleet.DTO.CreateCustomerRequestDto;
import com.example.FoodFleet.DTO.CreateCustomerResponseDto;
import com.example.FoodFleet.DTO.UpdateRequestDTO;
import com.example.FoodFleet.DTO.UpdateResponseDTO;
import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Mapper.CustomerMapper;
import com.example.FoodFleet.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public CreateCustomerResponseDto get(Long id){
        Customer customer = customerRepository.findById(id).get();
        CreateCustomerResponseDto customerResponseDto = customerMapper.mapToDTO(customer);
        return customerResponseDto;
    }
    public List<CreateCustomerResponseDto> getall(){
        List<Customer> customers = customerRepository.findAll();  // list find ki...
        List<CreateCustomerResponseDto> customerResponseDtos = new ArrayList<>(); // array create kiya..
        for(Customer customer :customers ){
            CreateCustomerResponseDto dto = customerMapper.mapToDTO(customer);    // Entity se ek ek karke DTO me convert kiya
            customerResponseDtos.add(dto);           // or array list me add kiya..
        }
        return customerResponseDtos;           // ArrayList retuen kardi..
    }

    public UpdateResponseDTO update(Long id, UpdateRequestDTO updateRequestDTO){
        Optional<Customer> customerGet = customerRepository.findById(id);
        Customer customer = customerGet.get();
        customerMapper.updateMapToEntity(updateRequestDTO,customer);
        customer.setUpdatedAt(LocalDateTime.now());

        Customer updateCustomer = customerRepository.save(customer);
        return customerMapper.updateMapToDTO(updateCustomer);
    }
//
//    public Customer delete(Long id){
//        Optional<Customer> customer = customerRepository.findById(id);
//        Customer getCustomer = customer.get();
//        return customerRepository.delete(getCustomer);
//    }
}
