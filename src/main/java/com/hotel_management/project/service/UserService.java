package com.hotel_management.project.service;

import com.hotel_management.project.dto.user.UserDTO;
import com.hotel_management.project.dto.user.UserUpdateDTO;
import com.hotel_management.project.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
   User getUserById(Integer id);
    User updateUser(User user,Integer id);
   void deleteUser(Integer id);
}
