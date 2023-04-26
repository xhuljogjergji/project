package com.hotel_management.project.service;

import com.hotel_management.project.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    List<Reservation>getAllReservations();
    Reservation getReservationById(Integer id);
    Reservation updateReservation(Integer id, Reservation reservation);
    void deleteReservation(Integer id);
    LocalDate getCheckInDate(Integer id);
    LocalDate getCheckOutDate(LocalDate localDate,Integer id);
}

