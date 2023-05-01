package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.room.RoomCategoryDTO;
import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomOptionDTO;
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
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomCategoryRepository roomCategoryRepository;

    @Override
    public Room findById(Integer id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Room not found", id)));
    }

    @Override
    public List<RoomDTO> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDTO addRoom(Integer catId, RoomDTO req) {
        RoomCategory roomCategory = roomCategoryRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Category with id %s not found", catId)));
        return RoomMapper.toDto(roomRepository
                .save(RoomMapper.toEntityRoom(req, roomCategory)));

    }

    @Override
    public RoomDTO updateRoom(Integer id, RoomUpdateDTO req) {
        Room toUpdate = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Room with id %s not found", id)));
        return RoomMapper.toDto(roomRepository
                .save(RoomMapper.toEntityUpdate(toUpdate, req)));
    }

    @Override
    public Boolean setRoomStatus(Integer id) {
        Room room = roomRepository.findById(id)
                .map(r -> {
                    r.setAvailable(r.isAvailable() ? false : true);
                    return r;
                }).map(roomRepository::save)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("Room with id %s not found", id)));
        return room.isAvailable();
    }
}