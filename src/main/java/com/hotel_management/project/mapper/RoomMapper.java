package com.hotel_management.project.mapper;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;
import com.hotel_management.project.entity.room.RoomCategory;

public class RoomMapper {
    public static RoomDTO toDto(Room r){
        return RoomDTO.builder()
                .id(r.getId())
                .name(r.getName())
                .available(r.isAvailable())
                .capacity(r.getCapacity())
                .pricePerNight(r.getPricePerNight())
                .build();
    }
    private static RoomDTO toEntity(RoomDTO r){
        return RoomDTO.builder()
                .id(r.getId())
                .name(r.getName())
                .capacity(r.getCapacity())
                .pricePerNight(r.getPricePerNight())
                .build();
    }
    public static RoomUpdateDTO toUpdateDto(Room r){
        return RoomUpdateDTO.builder()
                .id(r.getId())
                .name(r.getName())
                .capacity(r.getCapacity())
                .pricePerNight(r.getPricePerNight())
                .build();
    }
    public static Room buildUpdateRoom(Room r,RoomUpdateDTO req){
        r.setId(req.getId());
        r.setName(req.getName());
        r.setAvailable(req.isAvailable());
        r.setCapacity(req.getCapacity());
        r.setPricePerNight(req.getPricePerNight());
        return r;
    }

    public static Room toEntityUpdate(Room r,RoomUpdateDTO ru) {
r.setId(ru.getId());
r.setName(ru.getName());
r.setAvailable(ru.isAvailable());
r.setCapacity(ru.getCapacity());
r.setPricePerNight(ru.getPricePerNight());
return r;
    }

    public static Room toEntityRoom(RoomDTO ru, RoomCategory roomCategory) {
        return Room.builder()
                .name(ru.getName())
                .available(ru.isAvailable())
                .capacity(ru.getCapacity())
                .pricePerNight(ru.getPricePerNight())
                .roomCategory(roomCategory)
                .build();
    }
}
