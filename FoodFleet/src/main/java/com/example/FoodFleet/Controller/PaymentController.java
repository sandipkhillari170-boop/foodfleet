package com.example.FoodFleet.Controller;

import com.example.FoodFleet.PaymentDto.PaymentCerateRequestDto;
import com.example.FoodFleet.PaymentDto.PaymentResponseDto;
import com.example.FoodFleet.Service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private PaymentService paymentService;
    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDto> create(@RequestBody PaymentCerateRequestDto requestDto){
        return ResponseEntity.ok(paymentService.create(requestDto));
    }

}
