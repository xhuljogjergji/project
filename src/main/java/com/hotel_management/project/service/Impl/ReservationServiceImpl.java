package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.CheckOutDTO;
import com.hotel_management.project.dto.ReservationDTO;
import com.hotel_management.project.entity.Reservation;
import com.hotel_management.project.entity.ReservationStatus;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.mapper.ReservationMapper;
import com.hotel_management.project.repository.ReservationRepository;
import com.hotel_management.project.service.PaymentService;
import com.hotel_management.project.service.ReservationService;
import com.hotel_management.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private  final ReservationRepository reservationRepository;
private final PaymentService paymentService;
private final UserService userService;

    @Override
    public List<ReservationDTO> getReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<ReservationDTO> getReservationsByCustomerId(String email) {
        return reservationRepository.findAllByCustomerEmail(email)
                .stream().map(ReservationMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public Void setReservationStatus(Integer reservationId, String status) {
        reservationRepository.findById(reservationId)
                .map(res-> {
                    res.setReservationStatus(ReservationStatus.fromValue(status));
                    return reservationRepository.save(res);
                }).orElseThrow(()->new ResourceNotFoundException("reservation not found"));
        return null;
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
    @Override
    public LocalDate getCheckOutDate(long stayingDays,LocalDate localDate,Integer id) {
        Reservation reservation=reservationRepository.findById(id)
                .map(res -> {
                    res.setCheckOutDate(LocalDate.from(getCheckInDate(id)));
                    return res;
                }).map(reservationRepository::save)
                .orElseThrow(()->new ResourceNotFoundException(String
                .format("Reservation not found",id)));
        return reservation.getCheckOutDate().plusDays(stayingDays);
    }

    @Override
    public ReservationDTO processReservation(Jwt jwt, CheckOutDTO ch) {
        return null;
    }

}
