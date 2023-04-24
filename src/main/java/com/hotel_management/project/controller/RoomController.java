package com.hotel_management.project.controller;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;
import com.hotel_management.project.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
@RestControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/{id}")
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}/test")
    public Optional<Room> getRoomById(@PathVariable Integer id) {
        return Optional.ofNullable(roomService.getRoomById(id));
    }
    @RolesAllowed("ADMIN")
    @PostMapping("/admin/{id}")
    public ResponseEntity<RoomDTO> addRoom(@PathVariable Integer categoryId,
                                           @RequestBody RoomDTO req ){
        return ResponseEntity.ok(roomService.addRoom(categoryId,req));
    }
    @RolesAllowed("ADMIN")
    @PutMapping("/admin/ {id}")
    public RoomDTO updateRoom(@PathVariable Integer id, @RequestBody RoomUpdateDTO req) {
        return roomService.updateRoom(id, req);
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping("/admin/rooms/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }
}
