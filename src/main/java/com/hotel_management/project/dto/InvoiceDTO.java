package com.hotel_management.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDTO {
    private Integer id;

    private BigDecimal amount;

    private boolean paid;

    private ReservationDTO reservation;
    private int stayingDays;
}
