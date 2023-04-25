package com.hotel_management.project.controller;

import com.hotel_management.project.dto.room.RoomDTO;
import com.hotel_management.project.dto.room.RoomUpdateDTO;
import com.hotel_management.project.entity.room.Room;
import com.hotel_management.project.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping()
   public List<Room>getAllRooms(){
        return roomService.getAllRooms();
    }
    @PostMapping()
    public ResponseEntity<Room>saveRoom(@RequestBody Room room){
        return new ResponseEntity<Room>(roomService.saveRoom(room),HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id) {
        return new ResponseEntity<Room>(roomService.getRoomById(id), HttpStatus.OK);
    }
    @RolesAllowed("ADMIN")
    @PostMapping("/admin/{id}")
    public ResponseEntity<RoomDTO> addRoom(@PathVariable Integer categoryId,
                                           @RequestBody RoomDTO req ){
        return ResponseEntity.ok(roomService.addRoom(categoryId,req));
    }
    @RolesAllowed("ADMIN")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<String>("Room deleted successfully",HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Room>updateRoom(@PathVariable("id")Integer id,@RequestBody Room room){
        return new ResponseEntity<Room>(roomService.updateRoom(id,room),HttpStatus.OK);
    }
}
