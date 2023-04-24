package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.ReservationDTO;
import com.hotel_management.project.entity.Reservation;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.repository.ReservationRepository;
import com.hotel_management.project.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private  final ReservationRepository reservationRepository;

    @Override
    public Optional<Reservation> getReservationById(Integer id) {
        return Optional.ofNullable(reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Reservation with id %s not found", id))));
    }
//TODO:Return
    @Override
    public ReservationDTO addReservation(ReservationDTO req,Integer id) {
        return null;
    }


    @Override
    public ReservationDTO updateReservation(Integer id, ReservationDTO reservationDTO) {
        Reservation toUpdate=reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                .format("Reservation with id %s not found", id)));
        return null;
    }

    @Override
    public ReservationDTO deleteReservation(Integer id, ReservationDTO reservationDTO) {
        Reservation re=reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Reservation with id %s not found", id)));
        reservationRepository.delete(re);
        return null;
    }
}
