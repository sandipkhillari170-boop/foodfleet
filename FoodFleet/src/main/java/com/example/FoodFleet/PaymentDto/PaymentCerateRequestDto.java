package com.example.FoodFleet.PaymentDto;

public class PaymentCerateRequestDto {
    private Long orderId;
    private String paymentMethode;

    public Long getOrderId(){
        return orderId;
    }
    public void setOrderId(Long orderId){
        this.orderId = orderId;
    }

    public String getPaymentMethode() {
        return paymentMethode;
    }

    public void setPaymentMethode(String paymentMethode) {
        this.paymentMethode = paymentMethode;
    }
}
