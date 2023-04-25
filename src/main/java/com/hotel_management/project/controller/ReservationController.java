package com.hotel_management.project.controller;

import com.hotel_management.project.dto.ReservationDTO;
import com.hotel_management.project.entity.Reservation;
import com.hotel_management.project.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping("/")
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO,@PathVariable Integer id) {
        return reservationService.addReservation(reservationDTO,id);
    }

    @PutMapping("/{id}")
    public ReservationDTO updateReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(id, reservationDTO);
    }

    @DeleteMapping("/{id}")
    public ReservationDTO deleteReservation(@PathVariable Integer id,@RequestBody ReservationDTO reservationDTO) {
      return   reservationService.deleteReservation(id,reservationDTO);
    }
}
