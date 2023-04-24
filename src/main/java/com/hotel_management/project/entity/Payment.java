package com.hotel_management.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Double amount;
    private String transactionId;
    @CreatedDate
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
    }
}
