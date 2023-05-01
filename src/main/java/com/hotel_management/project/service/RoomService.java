package com.hotel_management.project.service;

import com.hotel_management.project.dto.room.RoomCategoryDTO;
import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomOptionDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;

import java.util.List;

public interface RoomService {
    Room findById(Integer id);
    List<RoomDTO> findAll();
    RoomDTO addRoom(Integer catId,RoomDTO req);
    RoomDTO updateRoom(Integer id,RoomUpdateDTO req);
    Boolean setRoomStatus(Integer id);
}
