package com.example.FoodFleet.Service;

import com.example.FoodFleet.DTO.CreateCustomerRequestDto;
import com.example.FoodFleet.DTO.CreateCustomerResponseDto;
import com.example.FoodFleet.DTO.UpdateCustomerRequestDTO;
import com.example.FoodFleet.DTO.UpdateCustomerResponseDTO;
import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Exception.ResourceNotFoundException;
import com.example.FoodFleet.Mapper.CustomerMapper;
import com.example.FoodFleet.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        Customer customer = customerRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()->
                        new ResourceNotFoundException(" Customer is not Exist with "+id));
        return customerMapper.mapToDTO(customer);

    }
    public List<CreateCustomerResponseDto> getall(){
        List<Customer> customers = customerRepository.findAllByDeletedFalse();  // list find ki...
        List<CreateCustomerResponseDto> customerResponseDtos = new ArrayList<>(); // array create kiya..
        for(Customer customer :customers ){
            CreateCustomerResponseDto dto = customerMapper.mapToDTO(customer);    // Entity se ek ek karke DTO me convert kiya
            customerResponseDtos.add(dto);           // or array list me add kiya..
        }
        return customerResponseDtos;           // ArrayList retuen kardi..
    }

    public UpdateCustomerResponseDTO update(Long id, UpdateCustomerRequestDTO updateRequestDTO){
        Customer customer = customerRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer is not Exist with"+ id + "for update"));
        customerMapper.updateMapToEntity(updateRequestDTO,customer);
        customer.setUpdatedAt(LocalDateTime.now());

        Customer updateCustomer = customerRepository.save(customer);
        return customerMapper.updateMapToDTO(updateCustomer);
    }

    public String delete(Long id){
       Customer customer = customerRepository.findById(id)
               .orElseThrow(()->
                       new ResourceNotFoundException("Customer is not found "));
         customerRepository.delete(customer);
         return "Customer delete parmantantlly";
    }

    public String softDelete(Long id){
        Customer customer = customerRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Customer is not found"));
        customer.setDeleted(true);
        customerRepository.save(customer);
        return "Customer delete soffly .";

    }
}
