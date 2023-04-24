package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;
import com.hotel_management.project.entity.room.RoomCategory;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.mapper.RoomMapper;
import com.hotel_management.project.repository.RoomCategoryRepository;
import com.hotel_management.project.repository.RoomRepository;
import com.hotel_management.project.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomCategoryRepository roomCategoryRepository;
    @Override
    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Room getRoomById(Integer id) {
        return roomRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Room with id %s not found",id)));
    }

    @Override
    public Room getRoom(RoomDTO roomDTO,Integer id) {
        return roomRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Room with id %s not found",id)));
    }

    @Override
    public RoomDTO updateRoom(Integer id, RoomUpdateDTO req) {
        Room toUpdate=roomRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Room with id %s not found",id)));
        return RoomMapper.toDto(roomRepository.save(RoomMapper.toEntityUpdate(toUpdate,req)));
    }

    @Override
    public  Room deleteRoom(Integer id) {
Room r=roomRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException(String
                .format("Room with id %s not found",id)));
roomRepository.delete(r);
return null;
    }

    @Override
    public RoomDTO addRoom(Integer id,RoomDTO req) {
        RoomCategory roomCategory= roomCategoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Room with id %s not found",id)));

        return RoomMapper.toDto(roomRepository.save(RoomMapper.toEntityRoom(req,roomCategory)));
    }
}
