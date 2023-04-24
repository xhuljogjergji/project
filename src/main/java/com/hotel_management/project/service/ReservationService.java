package com.hotel_management.project.service;

import com.hotel_management.project.dto.ReservationDTO;
import com.hotel_management.project.entity.Reservation;
import java.util.Optional;

public interface ReservationService {
    Optional<Reservation> getReservationById(Integer id);

    ReservationDTO addReservation(ReservationDTO reservationDTO,Integer id);

    ReservationDTO updateReservation(Integer id, ReservationDTO reservationDTO);

    ReservationDTO deleteReservation(Integer id, ReservationDTO reservationDTO);
}

