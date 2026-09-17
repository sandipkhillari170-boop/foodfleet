package com.example.FoodFleet.Controller;

import com.example.FoodFleet.PaymentDto.PaymentCerateRequestDto;
import com.example.FoodFleet.PaymentDto.PaymentResponseDto;
import com.example.FoodFleet.PaymentDto.UpdatePaymentRequstDto;
import com.example.FoodFleet.Service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private PaymentService paymentService;
    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDto> create( @Valid @RequestBody PaymentCerateRequestDto requestDto){
        return ResponseEntity.ok(paymentService.create(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> get(@PathVariable Long id){
        return  ResponseEntity.ok(paymentService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDto>> getAll(){
        return ResponseEntity.ok(paymentService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> update(@PathVariable Long id,
                                                     @RequestBody UpdatePaymentRequstDto requstDto){
        return ResponseEntity.ok(paymentService.update(id, requstDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(
            @PathVariable Long id) {

        return ResponseEntity.ok(paymentService.delete(id)
        );
    }
}
