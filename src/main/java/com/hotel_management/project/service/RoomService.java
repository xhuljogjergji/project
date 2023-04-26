package com.hotel_management.project.service;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;

import java.util.List;

public interface RoomService {
    Room saveRoom(Room room);
    List<Room> getAllRooms();
    Room getRoomById(Integer id);
    Room updateRoom(Integer id, Room room);
    void deleteRoom(Integer id);
    RoomDTO addRoom(Integer id,RoomDTO req);
    Boolean isRoomAvailable(Integer id);
}
