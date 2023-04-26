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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomCategoryRepository roomCategoryRepository;
    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
    @Override
    public Room getRoomById(Integer id) {
//        Optional<Room> room=roomRepository.findById(id);
//        if(room.isPresent()) {
//            return room.get();
//            }else{
//            throw new ResourceNotFoundException(String
//                        .format("Room with id %s not found",id));
//        }
        return roomRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Room with id %s not found",id)));
    }
    @Override
    public Room updateRoom(Integer id, Room room) {
    Room room1=roomRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Room with id %s not found",id)));
    room1.setName(room.getName());
    room1.setCapacity(room.getCapacity());
    room1.setAvailable(room.isAvailable());
    room1.setPricePerNight(room.getPricePerNight());
    roomRepository.save(room1);
        return room1;
    }

    @Override
    public  void deleteRoom(Integer id) {
    Room r=roomRepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException(String
                .format("Room with id %s not found",id)));
     roomRepository.delete(r);
    }

    @Override
    public RoomDTO addRoom(Integer id,RoomDTO req) {
        RoomCategory roomCategory= roomCategoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Room with id %s not found",id)));

        return RoomMapper.toDto(roomRepository.save(RoomMapper.toEntityRoom(req,roomCategory)));
    }

    @Override
    public Boolean isRoomAvailable(Integer id) {
        Room room=roomRepository.findById(id)
                .map(r->{
                    r.setAvailable(r.isAvailable()?false:true);
                    return r;
                }).map(roomRepository::save) .orElseThrow(()->new ResourceNotFoundException(String
                        .format("Room with id %s not found",id)));
        return room.isAvailable();
    }
}
