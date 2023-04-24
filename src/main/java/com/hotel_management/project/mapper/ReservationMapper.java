package com.hotel_management.project.mapper;

import com.hotel_management.project.dto.ReservationDTO;
import com.hotel_management.project.entity.Reservation;

public class ReservationMapper {
    public static ReservationDTO toEntity(ReservationDTO req, Reservation re){
        return ReservationDTO.builder()
                .id(re.getId())
                .room(re.getRoom()!=null?RoomMapper.toDto(re.getRoom()):null)
                .userDTO(re.getUser()!=null?UserMapper.toDto(re.getUser()):null)
                .numberOfGuests(re.getNumberOfGuests())
                .build();
    }

    public static ReservationDTO toDto(Reservation re){
        return ReservationDTO.builder()
                .id(re.getId())
                .room(re.getRoom()!=null?RoomMapper.toDto(re.getRoom()):null)
                .userDTO(re.getUser()!=null?UserMapper.toDto(re.getUser()):null)
                .numberOfGuests(re.getNumberOfGuests())
                .build();
    }
}
