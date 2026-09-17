package com.example.FoodFleet.Entity;


import jakarta.persistence.*;
import jakarta.websocket.OnMessage;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String paymentMethod;
    private Double amount;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true)

    private Order order;

}
