package com.example.FoodFleet.Controller;

import com.example.FoodFleet.RegisterDto.LoginRequestDto;
import com.example.FoodFleet.RegisterDto.RequestRegisterDto;
import com.example.FoodFleet.Service.AuthService;
import com.example.FoodFleet.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService =authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RequestRegisterDto registerDto){
        authService.register(registerDto);
        return ResponseEntity.ok("Customer registed successfuly");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto){
        authService.login(loginRequestDto);
        return ResponseEntity.ok("Loggin successfully !");
    }
}


