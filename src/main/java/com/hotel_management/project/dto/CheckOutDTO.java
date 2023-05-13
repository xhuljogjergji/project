package com.hotel_management.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CheckOutDTO {
    private String paymentMethod;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;

}
