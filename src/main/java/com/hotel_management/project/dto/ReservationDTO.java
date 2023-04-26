package com.hotel_management.project.dto;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {
    private Integer id;
    private RoomDTO room;
    private int numberOfGuests;
    private UserDTO userDTO;
    private String provider;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
