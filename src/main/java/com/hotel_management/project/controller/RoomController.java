package com.hotel_management.project.controller;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;
import com.hotel_management.project.mapper.RoomMapper;
import com.hotel_management.project.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;
    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findById(@PathVariable Integer id){
        RoomDTO r = RoomMapper.toDto(roomService.findById(id));
        return ResponseEntity.ok(r);
    }

    @GetMapping("/list")
    public ResponseEntity<List<RoomDTO>> findAllRooms(){
        return ResponseEntity.ok(roomService.findAll());
    }


    @RolesAllowed("ADMIN")
    @PostMapping("/admin/{categoryId}")
    public ResponseEntity<RoomDTO> addRooms(@PathVariable Integer categoryId,
                                                 @RequestBody RoomDTO req ){
        return ResponseEntity.ok(roomService.addRoom(categoryId,req));
    }

    @RolesAllowed("ADMIN")
    @PutMapping("/admin/{id}")
    public ResponseEntity<RoomDTO> updateProduct(@PathVariable Integer id,
                                                 @RequestBody RoomUpdateDTO req ){
        return ResponseEntity.ok(roomService.updateRoom(id,req));
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/{id}/status")
    public ResponseEntity<Boolean> setRoomStatus(@PathVariable Integer id){
        return ResponseEntity.ok(roomService.setRoomStatus(id));
    }
}