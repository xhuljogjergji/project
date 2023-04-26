package com.hotel_management.project.controller;

import com.hotel_management.project.dto.ReservationDTO;
import com.hotel_management.project.entity.Reservation;
import com.hotel_management.project.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping()
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<Reservation>
                (reservationService.saveReservation(reservation), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Reservation>(reservationService.getReservationById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<String>("Reservation canceled successfully", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") Integer id,
                                                         @RequestBody Reservation reservation) {
        return new ResponseEntity<Reservation>(reservationService.updateReservation(id, reservation)
                , HttpStatus.OK);
    }

    @GetMapping({"id"})
    public ResponseEntity<LocalDate> getCheckInDate(@PathVariable("id") Integer id,
                                                    @RequestBody Reservation reservation) {
        return new ResponseEntity<LocalDate>(reservationService.getCheckInDate(id), HttpStatus.OK);
    }

//    @GetMapping({"id"})
//    public ResponseEntity<LocalDate>getCheckOutDate(@PathVariable("id")Integer id,
//                                                    @RequestBody Reservation reservation){
//        return new ResponseEntity<LocalDate>(reservationService);
//
//    }
}
