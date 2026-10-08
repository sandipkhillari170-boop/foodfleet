package com.example.FoodFleet.Service;

import com.example.FoodFleet.Entity.Customer;
import com.example.FoodFleet.Entity.Restaurant;
import com.example.FoodFleet.Entity.User;
import com.example.FoodFleet.RegisterDto.LoginRequestDto;
import com.example.FoodFleet.RegisterDto.RequestRegisterDto;
import com.example.FoodFleet.Repository.CustomerRepository;
import com.example.FoodFleet.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthService {

    private UserRepository userRepository;
    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public AuthService(UserRepository userRepository, CustomerRepository customerRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this. jwtService = jwtService;
    }

    public void register(RequestRegisterDto registerDto) {

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole("CUSTOMER");

        User saveUser = userRepository.save(user);

        Customer customer = new Customer();

        customer.setName(registerDto.getName());
        customer.setEmail(registerDto.getEmail());
        customer.setPhoneNo(registerDto.getPhoneNo());
        customer.setUser(saveUser);

        customerRepository.save(customer);

    }

    public void registerOwner(RequestRegisterDto registerDto){

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole("OWNER");
        User saveUser = userRepository.save(user);

        Customer customer = new Customer();
        customer.setName(registerDto.getName());
        customer.setEmail(registerDto.getEmail());
        customer.setPhoneNo(registerDto.getPhoneNo());
        customer.setUser(saveUser);

        customerRepository.save(customer);

    }
//    public void login(LoginRequestDto requestDto){
//        UsernamePasswordAuthenticationToken token =
//                new UsernamePasswordAuthenticationToken(
//                        requestDto.getUsername(),
//                        requestDto.getPassword()
//
//                );
//        authenticationManager.authenticate(token);
//    }

    public String login(LoginRequestDto requestDto){
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(requestDto.getUsername(),
                        requestDto.getPassword()
                );
        authenticationManager.authenticate(token);

        return jwtService.generateToken(requestDto.getUsername());


    }
}
