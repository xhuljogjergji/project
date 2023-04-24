package com.hotel_management.project.service;

import com.hotel_management.project.dto.user.UserDTO;
import com.hotel_management.project.dto.user.UserUpdateDTO;
import com.hotel_management.project.entity.user.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Integer id);
    UserDTO registerUser(UserDTO req, String userRole);
    UserUpdateDTO updateUser(Integer id,UserUpdateDTO req);

}
