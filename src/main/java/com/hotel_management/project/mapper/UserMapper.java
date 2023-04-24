package com.hotel_management.project.mapper;

import com.hotel_management.project.dto.user.UserDTO;
import com.hotel_management.project.dto.user.UserUpdateDTO;
import com.hotel_management.project.entity.user.User;

public class UserMapper {
    public static UserDTO toDto(User u){
        return UserDTO.builder()
                .id(u.getId())
                .firstName(u.getFirstName())
                .build();
    }
    public static User toEntity(UserDTO u){
        return User.builder()
                .firstName(u.getFirstName())
                .lastName(u.getLastName())
                .email(u.getEmail())
                .phoneNo(u.getPhoneNo())
                .build();
    }
    public static UserUpdateDTO toUpdateDto(User u){
        return UserUpdateDTO.builder()
                .lastName(u.getLastName())
                .firstName(u.getFirstName())
                .email(u.getEmail())
                .id(u.getId())
                .build();
    }
    public static User buildUpdateUser(User u,UserUpdateDTO req){
        u.setId(req.getId());
        u.setFirstName(req.getFirstName());
        u.setLastName(req.getLastName());
        u.setEmail(req.getEmail());
        return u;
    }
}
