package com.hotel_management.project.service;

import com.hotel_management.project.dto.CheckOutDTO;
import com.hotel_management.project.dto.ReservationDTO;
import org.springframework.security.oauth2.jwt.Jwt;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    List<ReservationDTO> getReservations();
    Integer getReservationsByCustomerId(String email);
    Void setReservationStatus(Integer reservationId,String status);
    LocalDate getCheckInDate(Integer id);
    LocalDate getCheckOutDate(long stayingDays,LocalDate localDate,Integer id);

    ReservationDTO processReservation(Jwt jwt, CheckOutDTO ch);
}

