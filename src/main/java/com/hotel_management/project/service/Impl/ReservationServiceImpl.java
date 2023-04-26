package com.hotel_management.project.service.Impl;

import com.hotel_management.project.entity.Reservation;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.repository.ReservationRepository;
import com.hotel_management.project.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private  final ReservationRepository reservationRepository;
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    @Override
    public Reservation getReservationById(Integer id) {
        return reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Reservation not found",id)));
    }
    @Override
    public Reservation updateReservation(Integer id, Reservation reservation) {
        Reservation reservation1= reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Reservation not found",id)));
        reservation1.setRoom(reservation.getRoom());
        reservation1.setCheckInDate(reservation.getCheckInDate());
        reservation1.setCheckOutDate(reservation.getCheckOutDate());
        reservation1.setUser(reservation.getUser());
        reservation1.setNumberOfGuests(reservation.getNumberOfGuests());
        return reservation1;
    }
    @Override
    public void deleteReservation(Integer id) {
        Reservation re=reservationRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Reservation not found",id)));
        reservationRepository.delete(re);
    }

    @Override
    public LocalDate getCheckInDate(Integer id) {
        Reservation reservation=reservationRepository.findById(id)
                .map(res -> {
                    res.setCheckInDate(LocalDate.now());
                    return res;
                }).map(reservationRepository::save) .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Reservation not found",id)));
        return reservation.getCheckInDate();
    }
//TODO:add plus days
    @Override
    public LocalDate getCheckOutDate(LocalDate localDate,Integer id) {
        Reservation reservation=reservationRepository.findById(id)
                .map(res -> {
                    res.setCheckOutDate(LocalDate.from(getCheckInDate(id)));
                    return res;
                }).map(reservationRepository::save) .orElseThrow(()->new ResourceNotFoundException(String
                .format("Reservation not found",id)));
        return reservation.getCheckOutDate();
    }

}
