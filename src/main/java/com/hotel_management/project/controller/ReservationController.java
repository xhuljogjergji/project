package com.hotel_management.project.controller;

import com.hotel_management.project.dto.CheckOutDTO;
import com.hotel_management.project.dto.InvoiceDTO;
import com.hotel_management.project.dto.ReservationDTO;
import com.hotel_management.project.entity.Reservation;
import com.hotel_management.project.service.InvoiceService;
import com.hotel_management.project.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {
private final ReservationService reservationService;
private final InvoiceService invoiceService;
@GetMapping("/invoice")
public ResponseEntity<InvoiceDTO>getInvoice()
{return ResponseEntity.ok(invoiceService.getInvoice());}

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@AuthenticationPrincipal Jwt jwt,
                                                      @RequestBody CheckOutDTO ch){
        return ResponseEntity.ok(reservationService.processReservation(jwt,ch));
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<ReservationDTO>> getReservationByCustomerEmail
            (@PathVariable String email){
        return ResponseEntity.ok(reservationService.getReservationsByCustomerId(email));
    }

    @GetMapping("/{reservationID}/{reservationStatus}")
    public ResponseEntity<Void> setReservationStatus(@PathVariable Integer reservationId
            ,@PathVariable String reservationStatus){
        return ResponseEntity.ok(reservationService.setReservationStatus(reservationId,reservationStatus));
    }
    @PutMapping("/{id}/check-in-date")
    public ResponseEntity<LocalDate> getCheckInDate(@PathVariable Integer id) {
        LocalDate checkInDate = reservationService.getCheckInDate(id);
        return ResponseEntity.ok(checkInDate);
    }
@GetMapping("/{id}/check-out-date")
public ResponseEntity<LocalDate> getCheckOutDate(@PathVariable Integer id,
                                                 @RequestParam long stayingDays,
                                                 @RequestParam @DateTimeFormat
                                                         (iso = DateTimeFormat.ISO.DATE)
                                                 LocalDate checkInDate) {
    LocalDate checkOutDate = reservationService.getCheckOutDate(stayingDays, checkInDate, id);
    return ResponseEntity.ok(checkOutDate);
}
}
