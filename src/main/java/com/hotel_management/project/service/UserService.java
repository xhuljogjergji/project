package com.hotel_management.project.service;

import com.hotel_management.project.dto.user.UserDTO;
import com.hotel_management.project.dto.user.UserUpdateDTO;
import com.hotel_management.project.entity.user.User;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findById(Integer id);
    List<User> getAllUsers();
    UserDTO registerUser(UserDTO userDTO,String userRole);
   User getUserById(Integer id);
    UserUpdateDTO updateUser(UserUpdateDTO req,Integer id);
   void deleteUser(Integer id);
    User getUserFromToken(Jwt jwt);

    UserDTO createUser(UserDTO req);
}
