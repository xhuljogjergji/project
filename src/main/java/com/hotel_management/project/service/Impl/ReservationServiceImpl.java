package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.CheckOutDTO;
import com.hotel_management.project.dto.ReservationDTO;
import com.hotel_management.project.entity.Reservation;
import com.hotel_management.project.entity.ReservationStatus;
import com.hotel_management.project.entity.user.User;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.mapper.ReservationMapper;
import com.hotel_management.project.repository.ReservationRepository;
import com.hotel_management.project.repository.UserRepository;
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
    private final UserRepository userRepository;
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
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Reservation with ID %d not found", id)));

        reservation.setCheckInDate(LocalDate.now());
        reservation = reservationRepository.save(reservation);

        return reservation.getCheckInDate();
    }
    @Override
    public LocalDate getCheckOutDate(long stayingDays, LocalDate checkInDate, Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Reservation with ID %d not found", id)));

        LocalDate checkOutDate = checkInDate.plusDays(stayingDays);
        reservation.setCheckOutDate(checkOutDate);
        reservation = reservationRepository.save(reservation);

        return reservation.getCheckOutDate();
    }


    @Override
    public ReservationDTO processReservation(Jwt jwt, CheckOutDTO ch) {
        String customerEmail = jwt.getClaim("email").toString();
        User user = userRepository.findByEmail(customerEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setCheckInDate(ch.getCheckInDate());
        reservation.setCheckOutDate(ch.getCheckOutDate());
        reservation.setNumberOfGuests(ch.getNumberOfGuests());
        reservation.setReservationStatus(ReservationStatus.IN_PROGRESS);
        reservationRepository.save(reservation);

        return ReservationMapper.toDto(reservation);
    }
}
