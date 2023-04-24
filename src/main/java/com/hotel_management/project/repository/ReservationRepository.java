package com.hotel_management.project.repository;

import com.hotel_management.project.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    List<Reservation> findByCheckInDateBetween(LocalDate startDate, LocalDate endDate);

    List<Reservation> findByCheckOutDateBetween(LocalDate startDate, LocalDate endDate);
}
