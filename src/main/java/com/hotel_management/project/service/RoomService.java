package com.hotel_management.project.service;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getAllRooms();

    Room getRoomById(Integer id);
    Room getRoom(RoomDTO roomDTO,Integer id);

    RoomDTO updateRoom(Integer id, RoomUpdateDTO req);

    Room deleteRoom(Integer id);

    RoomDTO addRoom(Integer id,RoomDTO req);
}
