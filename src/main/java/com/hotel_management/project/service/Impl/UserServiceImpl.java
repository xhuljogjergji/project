package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.user.UserDTO;
import com.hotel_management.project.dto.user.UserUpdateDTO;
import com.hotel_management.project.entity.user.User;
import com.hotel_management.project.entity.user.UserRole;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.mapper.UserMapper;
import com.hotel_management.project.repository.UserRepository;
import com.hotel_management.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("User with id %snot found", id))));


    }

    @Override
    public UserDTO registerUser(UserDTO req, String userRole) {
        User u = UserMapper.toEntity(req);
        u.setRole(userRole != null ? UserRole.fromValue(userRole) : UserRole.GUEST);
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u = userRepository.save(u);
        return UserMapper.toDto(u);
    }

    @Override
    public UserUpdateDTO updateUser(Integer id, UserUpdateDTO req) {
        User u = findById(id).get();
        u = UserMapper.buildUpdateUser(u, req);
        return UserMapper.toUpdateDto(userRepository.save(u));
    }


}

