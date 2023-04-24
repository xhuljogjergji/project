package com.hotel_management.project.service.Impl;

import com.hotel_management.project.entity.Payment;
import com.hotel_management.project.entity.PaymentMethod;
import com.hotel_management.project.repository.PaymentRepository;
import com.hotel_management.project.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(String method, Double amount) {
        Payment p = new Payment();
        p.setPaymentMethod(PaymentMethod.fromValue(method));
        p.setAmount(amount);
        p.setTransactionId(UUID.randomUUID().toString());
        return null;
    }

    @Override
    public Void refund(Integer paymentId) {
        paymentRepository.deleteById(paymentId);
        return null;
    }
}
