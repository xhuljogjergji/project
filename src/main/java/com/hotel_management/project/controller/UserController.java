package com.hotel_management.project.controller;

import com.hotel_management.project.dto.user.UserDTO;
import com.hotel_management.project.dto.user.UserUpdateDTO;
import com.hotel_management.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @RolesAllowed("ADMIN")
    @PostMapping("/admin/{userRole}")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO req, @PathVariable String userRole){
        UserDTO dto = userService.registerUser(req,userRole);
        return ResponseEntity.ok(dto);
    }
    @RolesAllowed("ADMIN")
    @PutMapping("/admin/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser(@PathVariable Integer id, @RequestBody UserUpdateDTO req){
        UserUpdateDTO u = userService.updateUser(id,req);
        return ResponseEntity.ok(u);
    }
}
