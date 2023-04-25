package com.hotel_management.project.service;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room saveRoom(Room room);
    Room getRoomById(Integer id);
    Room updateRoom(Integer id, Room room);
    void deleteRoom(Integer id);

    RoomDTO addRoom(Integer id,RoomDTO req);
}
