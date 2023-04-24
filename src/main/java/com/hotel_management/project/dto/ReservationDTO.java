package com.hotel_management.project.dto;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
