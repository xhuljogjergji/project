package com.hotel_management.project.service;

import com.hotel_management.project.entity.Payment;

public interface PaymentService {
    Payment addPayment(String method, Double amount);
    Void refund(Integer paymentId);
}
